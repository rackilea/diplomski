Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
 List<File> filesList= (List<File>)sysClip.getData(DataFlavor.javaFileListFlavor);
          if(filesList!= null){
    Iterator<File> it = filesList.iterator();
    while(it.hasNext()){
        System.out.println(it.next().getAbsolutePath());
    }
}