import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class IsFolderSubdirectory {

    public static HashMap h = new HashMap();

    public static void addtoHashMap(File filename) {

        FileInputStream fin;
        try {
            fin = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fin));
            String n;
            try {
                while ((n = br.readLine()) != null) {
                    if (h.containsKey(n)) {
                        int i = (Integer) h.get(n);
                        h.put(n, (i + 1));
                    } else
                        h.put(n, 1);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void isfolder(File findfile) {
        if (findfile.isDirectory()) {
            System.out.println(findfile + "is a directory");
            String[] directoryContents = findfile.list();
            for (int i = 0; i < directoryContents.length; i++) {
                File newpath = new File(findfile + "/" + directoryContents[i]);
                isfolder(newpath);
            }
        } else {
            IsFolderSubdirectory.addtoHashMap(findfile);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String pathname = "GIVE YOUR PATH HERE";
        File file = new File(pathname);
        String[] directoryContents = file.list();
        IsFolderSubdirectory ifs = new IsFolderSubdirectory();

        for (int i = 0; i < directoryContents.length; i++) {
            File newpath = new File(pathname + "/" + directoryContents[i]);
            ifs.isfolder(newpath);
        }

    }
}