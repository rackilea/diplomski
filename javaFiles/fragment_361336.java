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