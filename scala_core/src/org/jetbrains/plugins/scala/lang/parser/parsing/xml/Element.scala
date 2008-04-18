package org.jetbrains.plugins.scala.lang.parser.parsing.xml

import com.intellij.lang.PsiBuilder, org.jetbrains.plugins.scala.lang.lexer.ScalaTokenTypes
import org.jetbrains.plugins.scala.lang.parser.ScalaElementTypes
import org.jetbrains.plugins.scala.lang.parser.bnf.BNF
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.tree.IElementType
import org.jetbrains.plugins.scala.lang.parser.util.ParserUtils
import org.jetbrains.plugins.scala.lang.lexer.ScalaElementType
import org.jetbrains.plugins.scala.ScalaBundle
import org.jetbrains.plugins.scala.lang.parser.parsing.expressions._
import com.intellij.psi.xml.XmlTokenType

/**
* @author Alexander Podkhalyuzin
* Date: 17.04.2008
*/

/*
 * Element::= EmptyElementTag
 *            | STag Content ETag
 */

object Element {
  def parse(builder: PsiBuilder): Boolean = {
    if (EmptyElemTag.parse(builder)) return true
    if (!STag.parse(builder)) return false
    Content parse builder
    if (!ETag.parse(builder)) builder error ErrMsg("xml.end.tag.expected") //TODO: add this error
    return true
  }
}