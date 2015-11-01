package de.bht.fpa.mail.s820789.fsnavigation.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * 
 */
public class HistoryHandler extends AbstractHandler {
  /**
   * The constructor.
   */
  public HistoryHandler() {
  }

  /**
   *initialize history window
   */
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchWindow historyWindow = HandlerUtil.getActiveWorkbenchWindowChecked(event);
    HistoryDialogue historyDialogue = new HistoryDialogue(historyWindow.getShell());
    FileObservable file = FileObservable.getInstance();

    int i = historyDialogue.open();

    if (i > -1) {
      file.setPath(SetBaseDirHandler.getPrefs().get(i + "", System.getProperty("user.home")));
    }

    return null;
  }

}
