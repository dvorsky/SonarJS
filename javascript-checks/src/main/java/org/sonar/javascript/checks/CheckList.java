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

import com.google.common.collect.ImmutableList;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Collectors;
import org.sonar.javascript.checks.annotations.JavaScriptRule;
import org.sonar.javascript.checks.annotations.TypeScriptRule;

public final class CheckList {

  public static final String JS_REPOSITORY_KEY = "javascript";
  public static final String TS_REPOSITORY_KEY = "typescript";

  public static final String REPOSITORY_NAME = "SonarAnalyzer";

  private CheckList() {
  }

  public static List<Class> getTypeScriptChecks() {
    return filterChecksByAnnotation(TypeScriptRule.class);
  }

  public static List<Class> getJavaScriptChecks() {
    return filterChecksByAnnotation(JavaScriptRule.class);
  }

  private static List<Class> filterChecksByAnnotation(Class<? extends Annotation> annotation) {
    List<Class> allChecks = getAllChecks();
    return allChecks.stream()
      .filter(c -> c.isAnnotationPresent(annotation))
      .collect(Collectors.toList());
  }

  public static List<Class> getAllChecks() {
    return ImmutableList.<Class>of(
      AlertUseCheck.class,
      ConditionalUnreachableCodeCheck.class,
      AlwaysUseCurlyBracesCheck.class,
      ArgumentsCallerCalleeUsageCheck.class,
      ArgumentsUsageCheck.class,
      ArgumentTypesCheck.class,
      ArithmeticOperationReturningNanCheck.class,
      ArrayConstructorsCheck.class,
      ArrayCallbackWithoutReturnCheck.class,
      ArrayMutatingOperationCheck.class,
      ArrowFunctionConventionCheck.class,
      AssignmentWithinConditionCheck.class,
      AssociativeArraysCheck.class,
      BackboneChangedIsUsedCheck.class,
      BitwiseOperatorsCheck.class,
      BooleanEqualityComparisonCheck.class,
      BoundOrAssignedEvalOrArgumentsCheck.class,
      BuiltInObjectOverriddenCheck.class,
      CallabilityCheck.class,
      ClassNameCheck.class,
      ClassPrototypeCheck.class,
      CognitiveComplexityFunctionCheck.class,
      CollapsibleIfStatementsCheck.class,
      CollectionSizeComparisonCheck.class,
      CommaOperatorInSwitchCaseCheck.class,
      CommaOperatorUseCheck.class,
      CommentedCodeCheck.class,
      CommentRegularExpressionCheck.class,
      ConsistentReturnsCheck.class,
      ValuesNotConvertibleToNumbersCheck.class,
      ComparisonWithNaNCheck.class,
      ConditionalCommentCheck.class,
      ConditionalIndentationCheck.class,
      ConditionalOperatorCheck.class,
      ConsoleLoggingCheck.class,
      ConstructorFunctionsForSideEffectsCheck.class,
      ContinueStatementCheck.class,
      CookiesCheck.class,
      CorsCheck.class,
      CounterUpdatedInLoopCheck.class,
      DeadStoreCheck.class,
      DebuggerStatementCheck.class,
      DeclarationInGlobalScopeCheck.class,
      DefaultParameterSideEffectCheck.class,
      DefaultParametersNotLastCheck.class,
      DeleteArrayElementCheck.class,
      DeleteNonPropertyCheck.class,
      DeprecatedCheck.class,
      DeprecatedJQueryAPICheck.class,
      DestructuringAssignmentSyntaxCheck.class,
      DifferentTypesComparisonCheck.class,
      DuplicateAllBranchImplementationCheck.class,
      DuplicateBranchImplementationCheck.class,
      DuplicateConditionIfCheck.class,
      DuplicateFunctionArgumentCheck.class,
      DuplicatePropertyNameCheck.class,
      ElementTypeSelectorCheck.class,
      ElementUsedWithClassSelectorCheck.class,
      ElseIfWithoutElseCheck.class,
      EmptyBlockCheck.class,
      EmptyDestructuringPatternCheck.class,
      EmptyFunctionCheck.class,
      EmptyStatementCheck.class,
      EncryptionCheck.class,
      EqEqEqCheck.class,
      EqualInForLoopTerminationCheck.class,
      ErrorWithoutThrowCheck.class,
      EvalCheck.class,
      MaxParameterCheck.class,
      ExpressionComplexityCheck.class,
      FileHeaderCheck.class,
      FileNameDiffersFromClassCheck.class,
      FixmeTagPresenceCheck.class,
      ForHidingWhileCheck.class,
      ForInCheck.class,
      ForLoopConditionAndUpdateCheck.class,
      ForLoopIncrementSignCheck.class,
      FunctionCallArgumentsOnNewLineCheck.class,
      FunctionComplexityCheck.class,
      FunctionConstructorCheck.class,
      FunctionDeclarationsWithinBlocksCheck.class,
      FunctionDefinitionInsideLoopCheck.class,
      FunctionNameCheck.class,
      FutureReservedWordsCheck.class,
      FunctionReturnTypeCheck.class,
      GeneratorWithoutYieldCheck.class,
      GetterSetterCheck.class,
      GlobalThisCheck.class,
      HashingCheck.class,
      HtmlCommentsCheck.class,
      IdChildrenSelectorCheck.class,
      IdenticalExpressionOnBinaryOperatorCheck.class,
      IdenticalFunctionsCheck.class,
      IfConditionalAlwaysTrueOrFalseCheck.class,
      ImmediatelyReturnedVariableCheck.class,
      InconsistentFunctionCallCheck.class,
      IncrementDecrementInSubExpressionCheck.class,
      IndexOfCompareToPositiveNumberCheck.class,
      InOperatorTypeErrorCheck.class,
      InstanceofInMisuseCheck.class,
      InvariantReturnCheck.class,
      JQueryVarNameConventionCheck.class,
      JumpStatementInFinallyCheck.class,
      LabelledStatementCheck.class,
      LabelPlacementCheck.class,
      LineLengthCheck.class,
      LocalStorageCheck.class,
      LoopsShouldNotBeInfiniteCheck.class,
      MaxSwitchCasesCheck.class,
      MisorderedParameterListCheck.class,
      MissingNewlineAtEndOfFileCheck.class,
      MissingTrailingCommaCheck.class,
      ModelDefaultsWithArrayOrObjectCheck.class,
      MultilineBlockCurlyBraceCheck.class,
      MultilineStringLiteralsCheck.class,
      NamedFunctionExpressionCheck.class,
      NestedConditionalOperatorsCheck.class,
      NestedControlFlowDepthCheck.class,
      NewOperatorMisuseCheck.class,
      NoDuplicateStringCheck.class,
      NoElementOverwriteCheck.class,
      NoEvalCheck.class,
      NoInvertedBooleanCheckCheck.class,
      NoMagicNumbersCheck.class,
      NonCaseLabelInSwitchCheck.class,
      NonEmptyCaseWithoutBreakCheck.class,
      NonExistentAssignmentOperatorCheck.class,
      NonExistentPropertyAccessCheck.class,
      NonNumberInArithmeticExpressionCheck.class,
      NonStandardImportCheck.class,
      NotStoredSelectionCheck.class,
      NoUnnecessaryTypeAssertionCheck.class,
      NoUselessCatchCheck.class,
      NullDereferenceCheck.class,
      NullDereferenceInConditionalCheck.class,
      ObjectLiteralShorthandCheck.class,
      OctalNumberCheck.class,
      OneStatementPerLineCheck.class,
      OpenCurlyBracesAtEOLCheck.class,
      OSCommandCheck.class,
      ParenthesesCheck.class,
      ParseIntCallWithoutBaseCheck.class,
      ParsingErrorCheck.class,
      PostMessageCheck.class,
      PreferObjectLiteralCheck.class,
      PrimitiveWrappersCheck.class,
      ProcessArgvCheck.class,
      PseudoRandomCheck.class,
      ReassignedParameterCheck.class,
      RedeclaredSymbolCheck.class,
      GratuitousConditionCheck.class,
      RedundantAssignmentCheck.class,
      ReferenceErrorCheck.class,
      RegularExprCheck.class,
      ReturnInSetterCheck.class,
      ReturnOfBooleanExpressionCheck.class,
      ReturnValueNotIgnoredCheck.class,
      SameLineConditionalCheck.class,
      SameModuleImportsCheck.class,
      SelectionTestedWithoutLengthCheck.class,
      SelfAssignmentCheck.class,
      SemicolonCheck.class,
      ShorthandPropertiesNotGroupedCheck.class,
      SocketsCheck.class,
      SpaceInModelPropertyNameCheck.class,
      SqlQueriesCheck.class,
      StandardInputCheck.class,
      StrictModeCheck.class,
      StringConcatenatedWithNonStringCheck.class,
      StringConcatenationCheck.class,
      StringLiteralsQuotesCheck.class,
      StringsComparisonCheck.class,
      SuperInvocationCheck.class,
      SwitchWithNotEnoughCaseCheck.class,
      SwitchWithoutDefaultCheck.class,
      SymbolUsedAsConstructorCheck.class,
      TabCharacterCheck.class,
      TemplateStringMisuseCheck.class,
      TodoTagPresenceCheck.class,
      TooManyArgumentsCheck.class,
      TooManyBreakOrContinueInLoopCheck.class,
      TooManyLinesInFileCheck.class,
      TooManyLinesInFunctionCheck.class,
      TrailingCommaCheck.class,
      TrailingCommentCheck.class,
      TrailingWhitespaceCheck.class,
      UnaryPlusMinusWithObjectCheck.class,
      UnchangedLetVariableCheck.class,
      UnconditionalJumpStatementCheck.class,
      UndefinedAssignmentCheck.class,
      GlobalsShadowingCheck.class,
      UniversalSelectorCheck.class,
      UnreachableCodeCheck.class,
      UntrustedContentCheck.class,
      UnusedCollectionCheck.class,
      UnusedFunctionArgumentCheck.class,
      UnusedImportCheck.class,
      UnusedVariableCheck.class,
      UpdatedConstVariableCheck.class,
      UselessExpressionStatementCheck.class,
      UselessIncrementCheck.class,
      UselessStringOperationCheck.class,
      UseOfEmptyReturnValueCheck.class,
      VarDeclarationCheck.class,
      VariableDeclarationAfterUsageCheck.class,
      VariableDeclarationWithoutVarCheck.class,
      VariableShadowingCheck.class,
      VoidUseCheck.class,
      WebSQLDatabaseCheck.class,
      WildcardImportCheck.class,
      WithStatementCheck.class,
      WrongScopeDeclarationCheck.class,
      XpathCheck.class,
      YieldOutsideGeneratorCheck.class);
  }

}
