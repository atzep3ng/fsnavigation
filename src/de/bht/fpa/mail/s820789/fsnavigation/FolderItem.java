package de.bht.fpa.mail.s820789.fsnavigation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;

import org.eclipse.swt.graphics.Image;

import de.bht.fpa.mail.s000000.common.mail.model.IMessageTreeItem;
import de.bht.fpa.mail.s000000.common.mail.model.Message;

public class FolderItem extends FileTreeItem {

  public FolderItem(File file) {
    super(file);
  }

  @Override
  public Image getImage() {
    return Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/folder.png").createImage();
  }

  @Override
  public boolean hasChildren() {
    // TODO Auto-generated method stub
    return file.list() != null;
  }

  @Override
  public List<IMessageTreeItem> getChildren() {
    ArrayList<IMessageTreeItem> children = new ArrayList<>();

    for (File item : file.listFiles()) {
      if (item.isDirectory()) {
        children.add(new FolderItem(item));
      } else {
        children.add(new FileItem(item));
      }
    }

    return children;
  }

  public List<Message> getMessages() {
    File f = new File("");

    try {
      Message msg = JAXB.unmarshal(f, Message.class);
//      msg.getId();
    } catch (Exception ex) {
        // Exception verschlucken
    }
    return null;
  }
}
