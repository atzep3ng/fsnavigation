package de.bht.fpa.mail.s820789.fsnavigation;

import java.io.File;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import de.bht.fpa.mail.s000000.common.mail.model.IMessageTreeItem;
import de.bht.fpa.mail.s000000.common.mail.model.Message;

public class NavigationView extends ViewPart implements ISelectionChangedListener, Observer{

    private TreeViewer viewer;
  
  @Override
 
    public void createPartControl(Composite parent) {
      viewer = new TreeViewer(parent);
      viewer.setContentProvider(new FsContentProvider());
      viewer.setLabelProvider(new FsLabelProvider());
      
      String path = System.getProperty("user.home");
      IMessageTreeItem in = new FolderItem(new File(path));
      BaseDirSubject.getInstance().addObserver(this);
      
      viewer.setInput(in);
    
      viewer.addSelectionChangedListener(this);
      
     
  }

  @Override
  public void setFocus() {
    // TODO Auto-generated method stub
    
  }
  
  
  public void update(Observable arg0, Object arg1){
    String newPath = BaseDirSubject.getInstance().getPath();
    IMessageTreeItem newIn = new FolderItem(new File(newPath));
    viewer.setInput(newIn);
    
  }

  @Override
  public void selectionChanged(SelectionChangedEvent event) {
    // wenn Benutzer neuen Ordner auswählt wird diese M. aufgerufen
    
    IStructuredSelection ts = (IStructuredSelection)event.getSelection();
    IMessageTreeItem ti = (IMessageTreeItem)ts.getFirstElement();
    List<Message> messages = ti.getMessages();
    for(Message msg : messages){
      System.out.println(msg.toShortString());
    }
    
  }

}
