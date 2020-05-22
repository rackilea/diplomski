public class Filewalker {

    public void walk(File root) {

        File[] list = root.listFiles();

        for (File f : list) {
            if (f.isDirectory()) {
                Log.d("", "Dir: " + f.getAbsoluteFile());
                walk(f);
            }
            else {
                Log.d("", "File: " + f.getAbsoluteFile());
            }
        }
    }   
}