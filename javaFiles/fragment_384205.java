for (int i = 0; i < count; i++) {
    MyPanel panel = (MyPanel) tabbedPane.getTabComponentAt(i);
    if(panel == null) continue; 
    flag = panel.hasFile(file); //checks if new file contained in selected panel(added through constructor)
    if (flag) break;
 }