package de.bht.fpa.mail.s820789.fsnavigation;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import de.bht.fpa.mail.s000000.common.mail.model.IMessageTreeItem;

public class FsLabelProvider extends LabelProvider {

  @Override
  public Image getImage(Object element) {
    if (element instanceof IMessageTreeItem) {
      IMessageTreeItem item = (IMessageTreeItem) element;
      return item.getImage();
    }
    return super.getImage(element);
  }

  @Override
  public String getText(Object element) {
    if (element instanceof IMessageTreeItem) {
      IMessageTreeItem item = (IMessageTreeItem) element;
      return item.getText();
    }
    return super.getText(element);
  }

}
