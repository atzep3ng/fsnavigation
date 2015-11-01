package de.bht.fpa.mail.s820789.fsnavigation.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * 
 */
public class SetHistoryDirHandler extends AbstractHandler {
  /**
   * The constructor.
   */
  public SetHistoryDirHandler() {
  }

  /**
   *
   */
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
    HistoryDialog hd = new HistoryDialog(window.getShell());
    FileObservable file = FileObservable.getInstance();

    int i = hd.open();

    if (i > -1) {
      file.setPath(SetBaseDirHandler.getPrefs().get(i + "", System.getProperty("user.home")));
    }

    return null;
  }

}
