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

import org.sonar.check.Rule;
import org.sonar.javascript.checks.annotations.JavaScriptRule;
import org.sonar.javascript.checks.utils.CheckUtils;
import org.sonar.plugins.javascript.api.tree.Tree.Kind;
import org.sonar.plugins.javascript.api.tree.expression.NewExpressionTree;
import org.sonar.plugins.javascript.api.visitors.DoubleDispatchVisitorCheck;

@JavaScriptRule
@Rule(key = "S3984")
public class ErrorWithoutThrowCheck extends DoubleDispatchVisitorCheck {

  private static final String MESSAGE = "Throw this error or remove this useless statement.";

  @Override
  public void visitNewExpression(NewExpressionTree tree) {
    if (tree.parent().is(Kind.EXPRESSION_STATEMENT) && CheckUtils.asString(tree.expression()).endsWith("Error")) {
      addIssue(tree, MESSAGE);
    }
    super.visitNewExpression(tree);
  }
}
