package de.bht.fpa.mail.s820789.fsnavigation.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

public class HistoryDialogue extends Dialog {

  private int index = -1;

  protected HistoryDialogue(Shell parentShell) {
    super(parentShell);
  }

  @Override
  protected Control createDialogArea(Composite parent) {

    final int windowWidth = 200;
    final int windowHeight = 200;

    Composite composite = (Composite) super.createDialogArea(parent);
    composite.getShell().setText("A dialog box with no buttons at all press 'ESC' to close");
    Composite compo = new Composite(composite, SWT.SCROLLBAR_OVERLAY);
    ListViewer listViewer = new ListViewer(compo, SWT.V_SCROLL);
    System.out.println(parent.getSize());
    listViewer.getList().setSize(windowWidth, windowHeight);

    for (String s : getEntries()) {
      listViewer.add(s);
    }

    if (listViewer.getList().getItemCount() == 0) {
      listViewer.add("No base directories in history");
      listViewer.getList().setEnabled(false);
    }
    listViewer.addSelectionChangedListener(e -> index = listViewer.getList().getItemCount() - listViewer.getList().getSelectionIndex() - 1);

    return super.createDialogArea(parent);
  }

  @Override
  public int open() {
    super.open();
    return index;
  }

  private List<String> getEntries() {

    Preferences preferences = SetBaseDirHandler.getPrefs();
    List<String> choices = new ArrayList<>();
    try {

      for (String k : preferences.keys()) {
        choices.add(preferences.get(k, ""));
      }
      Collections.reverse(choices);
    } catch (BackingStoreException e) {
      e.getStackTrace();
    }

    return choices;
  }

}