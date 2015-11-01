package de.bht.fpa.mail.s820789.fsnavigation.handlers;

import java.util.Observable;

import de.bht.fpa.mail.s820789.fsnavigation.NavigationView;

public class FileObservable extends Observable{

  private String path;
  private static final FileObservable FILE_OBSERVABLE = new FileObservable();

  private FileObservable() {
  }

  public static FileObservable getInstance() {
    return FILE_OBSERVABLE;
  }
  
  public void setPath(String path) {
    setChanged();
    this.path = path;
    notifyObservers(path);
  }

  public String getPath() {
    return path;
  }


}
