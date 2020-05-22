// Check to see if the GUI subsystem is initialized correctly. (This is needed in JDK 1.2 and higher). If it isn't ready, then we have to wait. 

  if (EventQueueMonitor.isGUIInitialized()) { 
    createGUI(); 
  } else { 
    EventQueueMonitor.addGUIInitializedListener(this); 
  } 
} 

public void guiInitialized() { 
  createGUI(); 
}