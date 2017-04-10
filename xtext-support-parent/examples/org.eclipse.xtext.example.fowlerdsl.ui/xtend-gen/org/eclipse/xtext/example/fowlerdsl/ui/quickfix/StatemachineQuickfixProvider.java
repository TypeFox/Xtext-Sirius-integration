/**
 * generated by Xtext
 */
package org.eclipse.xtext.example.fowlerdsl.ui.quickfix;

import org.eclipse.xtext.example.fowlerdsl.validation.StatemachineValidator;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Custom quickfixes.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#quickfixes
 */
@SuppressWarnings("all")
public class StatemachineQuickfixProvider extends DefaultQuickfixProvider {
  @Fix(StatemachineValidator.INVALID_NAME)
  public void capitalizeName(final Issue issue, final IssueResolutionAcceptor acceptor) {
    String _firstLower = StringExtensions.toFirstLower(IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(issue.getData()))));
    String _plus = ("Change to \'" + _firstLower);
    String _plus_1 = (_plus + "\'.");
    String _firstLower_1 = StringExtensions.toFirstLower(IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(issue.getData()))));
    String _plus_2 = ("Change to \'" + _firstLower_1);
    String _plus_3 = (_plus_2 + "\'.");
    final IModification _function = new IModification() {
      @Override
      public void apply(final IModificationContext it) throws Exception {
        final String firstLetter = it.getXtextDocument().get((issue.getOffset()).intValue(), 1);
        it.getXtextDocument().replace((issue.getOffset()).intValue(), 1, firstLetter.toLowerCase());
      }
    };
    acceptor.accept(issue, _plus_1, _plus_3, "upcase.png", _function);
  }
}
