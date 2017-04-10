/**
 * generated by Xtext
 */
package org.eclipse.xtext.example.fowlerdsl.formatting;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.example.fowlerdsl.services.StatemachineGrammarAccess;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation.html#formatting
 * on how and when to use it
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
@SuppressWarnings("all")
public class StatemachineFormatter extends AbstractDeclarativeFormatter {
  @Inject
  @Extension
  private StatemachineGrammarAccess _statemachineGrammarAccess;
  
  @Override
  protected void configureFormatting(final FormattingConfig c) {
    List<Pair<Keyword, Keyword>> _findKeywordPairs = this._statemachineGrammarAccess.findKeywordPairs("{", "}");
    for (final Pair<Keyword, Keyword> pair : _findKeywordPairs) {
      {
        c.setIndentationIncrement().after(pair.getFirst());
        c.setIndentationDecrement().before(pair.getSecond());
        c.setLinewrap(1, 1, 2).after(pair.getFirst());
        c.setLinewrap(1, 1, 2).before(pair.getSecond());
        c.setLinewrap(1, 2, 2).after(pair.getSecond());
      }
    }
    List<Keyword> _findKeywords = this._statemachineGrammarAccess.findKeywords("events", "commands", "services", "state");
    for (final Keyword start : _findKeywords) {
      {
        c.setLinewrap(2, 2, 2).before(start);
        c.setIndentationIncrement().after(start);
      }
    }
    List<Keyword> _findKeywords_1 = this._statemachineGrammarAccess.findKeywords("actions");
    for (final Keyword start_1 : _findKeywords_1) {
      c.setLinewrap(1, 1, 2).before(start_1);
    }
    List<Keyword> _findKeywords_2 = this._statemachineGrammarAccess.findKeywords("end", "do");
    for (final Keyword end : _findKeywords_2) {
      c.setLinewrap(1, 1, 2).before(end);
    }
    List<Keyword> _findKeywords_3 = this._statemachineGrammarAccess.findKeywords("end");
    for (final Keyword end_1 : _findKeywords_3) {
      c.setIndentationDecrement().before(end_1);
    }
    c.setLinewrap(1, 1, 2).before(this._statemachineGrammarAccess.getTransitionAccess().getEventAssignment_0());
  }
}
