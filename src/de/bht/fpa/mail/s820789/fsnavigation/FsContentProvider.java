package de.bht.fpa.mail.s820789.fsnavigation;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class FsContentProvider implements ITreeContentProvider {

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    
  }

  @Override
  public Object[] getElements(Object inputElement) {
    return getChildren(inputElement);
  }

  @Override
  public Object[] getChildren(Object parentElement) {
    // wenn man Verzeichnis aufklappt wird diese Methode gerufen, Elemente
    // unterhalb eines Knotens
    // statt String IMessageTreeItem
    return ((FileTreeItem) parentElement).getChildren().toArray();

  }

  @Override
  public Object getParent(Object element) {
    // Vaterknoten von einem Element zu bekommen, wird ignoriert brauchen wir
    // nicht
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    // hat ein Knoten Kinder? True bedeutet, + zum Aufklappen
    return ((FileTreeItem) element).hasChildren();
  }

}
