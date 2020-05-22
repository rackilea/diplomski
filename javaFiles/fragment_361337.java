private DefaultTableModel model=new DefaultTableModel();
private ArrayList<ArrayList<String>> image=new ArrayList<ArrayList<String>>();
public void imageshow( String path ) throws IOException {
    File root = new File( path );
    File[] list = root.listFiles();
    if (list == null) return;
    for ( File f : list ) {
        imageshow(f.getAbsolutePath());
        if(f.getName().endsWith("jpg")||f.getName().endsWith("png")||f.getName().endsWith("gif")||f.getName().endsWith("tif"))
            {
            ArrayList<String> row = new ArrayList<String>();
            row.add(f.getName());
            images.add(row);
            image_count++;
        }
    }
}
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){
    DirectoryReader fw = new DirectoryReader();
    images.clear();
    System.out.println("---Images----");
    try {
         fw.imageshow("D:\\Installs\\shohruh\\doc");
    } catch (IOException ex) {
        Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
    }
    model.addColumn("Imya");
    table.setModel(model);
    for(ArrayList<String> list:images)
         model.addRow(new Vector(list));
}