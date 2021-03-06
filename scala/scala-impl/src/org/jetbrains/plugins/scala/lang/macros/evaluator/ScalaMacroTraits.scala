/*
 * Copyright 2000-2014 JetBrains s.r.o.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.plugins.scala.lang.macros.evaluator

import com.intellij.psi.PsiElement
import org.jetbrains.plugins.scala.lang.psi.api.expr.{MethodInvocation, ScExpression}
import org.jetbrains.plugins.scala.lang.psi.api.statements.ScFunction
import org.jetbrains.plugins.scala.lang.psi.types._
import org.jetbrains.plugins.scala.lang.resolve.ScalaResolveResult

/**
 * @author Mikhail.Mutcianko
 *         date 22.12.14
 */

case class MacroContext(place: PsiElement, expectedType: Option[ScType])

trait ScalaMacroTypeable {
  def checkMacro(macros: ScFunction, context: MacroContext): Option[ScType]
}

case class MacroInvocationContext(call: MethodInvocation, resolveResult: ScalaResolveResult)

trait ScalaMacroExpandable {
  def expandMacro(macros: ScFunction, context: MacroInvocationContext): Option[ScExpression]
}