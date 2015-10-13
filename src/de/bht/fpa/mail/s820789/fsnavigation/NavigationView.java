package de.bht.fpa.mail.s820789.fsnavigation;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class NavigationView extends ViewPart{

  @Override
  public void createPartControl(Composite parent) {
  
    TreeViewer viewer = new TreeViewer(parent, SWT.NONE);
    
    viewer.setContentProvider(new FsContentProvider());
    viewer.setLabelProvider(new FsLabelProvider());
    viewer.setInput("Input");
    
  }

  @Override
  public void setFocus() {
    // TODO Auto-generated method stub
    
  }

}
