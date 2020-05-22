DefaultListModel model1 = new DefaultListModel();
    File o = new File("c:/");

    File[] yourFileList = o.listFiles();
    for(File f : yourFileList) {
        model1.addElement(f.getName());
    }
    jList1.setModel(model1);