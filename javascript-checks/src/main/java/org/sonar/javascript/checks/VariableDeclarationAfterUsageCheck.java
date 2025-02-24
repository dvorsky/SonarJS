/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011-2019 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.javascript.checks;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.sonar.check.Rule;
import org.sonar.javascript.checks.annotations.JavaScriptRule;
import org.sonar.plugins.javascript.api.symbols.Symbol;
import org.sonar.plugins.javascript.api.symbols.SymbolModel;
import org.sonar.plugins.javascript.api.symbols.Usage;
import org.sonar.plugins.javascript.api.tree.ScriptTree;
import org.sonar.plugins.javascript.api.visitors.DoubleDispatchVisitorCheck;
import org.sonarsource.analyzer.commons.annotations.DeprecatedRuleKey;

@JavaScriptRule
@DeprecatedRuleKey(ruleKey = "VariableDeclarationAfterUsage")
@Rule(key = "S1526")
public class VariableDeclarationAfterUsageCheck extends DoubleDispatchVisitorCheck {

  private static final String MESSAGE = "Move the declaration of \"%s\" before this usage.";

  @Override
  public void visitScript(ScriptTree tree) {
    SymbolModel symbolModel = getContext().getSymbolModel();
    for (Symbol symbol : symbolModel.getSymbols()) {
      if (symbol.isVariable()) {
        visitSymbol(symbol);
      }
    }
  }

  private static class LineComparator implements Comparator<Usage> {

    @Override
    public int compare(Usage usage1, Usage usage2) {
      return Integer.compare(getLine(usage1), getLine(usage2));
    }

    private static int getLine(Usage usage) {
      return usage.identifierTree().identifierToken().line();
    }
  }

  private void visitSymbol(Symbol symbol) {
    List<Usage> usages = new LinkedList<>(symbol.usages());

    if (!usages.isEmpty()) {

      Collections.sort(usages, new LineComparator());

      if (usages.get(0).isDeclaration()) {
        return;
      }

      for (int i = 1; i < usages.size(); i++) {
        if (usages.get(i).isDeclaration()) {
          addIssue(usages.get(0).identifierTree(), String.format(MESSAGE, symbol.name()))
            .secondary(usages.get(i).identifierTree(), "Declaration");
          return;
        }
      }

    }
  }

}
