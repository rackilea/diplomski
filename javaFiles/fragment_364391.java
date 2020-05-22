public class FileResolverGenerator {

    private static final String newFilePath = "C:/Users/Foo/Desktop/Jsps.java";
    private static final String scanRootFolder = "C:/Users/Foo/Desktop/myProject/web/WEB-INF/jsp";

    private static final String varValueReplaceSource = "C:/Users/Foo/Desktop/myProject/web/WEB-INF/jsp/";
    private static final String varValueReplaceTarget = "";

    private static final boolean valueAlign = true;
    private static final int varNameSpaces = 15;


    public static void main(String[] args){
        try {
            // Create file and a writer
            File f = new File(newFilePath);
            f.createNewFile();
            bw = new BufferedWriter( new FileWriter(f) );
            // Execute
            filesParser( new File(scanRootFolder) );
            // 'Burn' file
            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ResolverGenerator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResolverGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // ================================================================================================ //
    // ============================================= WORK ============================================= //
    // ================================================================================================ //

    private static void filesParser(File rootFolder) throws FileNotFoundException, IOException{

        folderIn(rootFolder);
        // Files first
        if(!rootFolder.exists()) throw new FileNotFoundException();
        for(File f : rootFolder.listFiles()){
            if(f==null){ return; }
            if(f.isDirectory()){ continue; }
            else if(f.isFile()){ writeFileVariable(f); }
        }
        // Folders next
        for(File f : rootFolder.listFiles()){
            if(f==null){ return; }
            if(f.isDirectory()){ filesParser(f); }
            else if(f.isFile()){ continue; }
        }
        folderOut(rootFolder);
    }


    // ================================================================================================ //
    // ============================================ PRINTS ============================================ //
    // ================================================================================================ //
    private static BufferedWriter bw;
    private static int tabCount = 0;


    private static void folderIn(File f) throws IOException{
        bw.append("\n\n");
        for(int i=0; i<tabCount; i++)
            bw.append("\t");
        bw.append("public class "+f.getName()+"{\n");
        tabCount++;
    }

    private static void folderOut(File f) throws IOException{
        tabCount--;
        for(int i=0; i<tabCount; i++)
            bw.append("\t");
        bw.append("}\n");
    }

    private static void writeFileVariable(File f) throws IOException{
        String varName = f.getName().split("\\.")[0].replaceAll("-", "");
        String varValue = f.getPath().replaceAll("\\\\","/")
           .replace(varValueReplaceSource.replaceAll("\\\\","/"),varValueReplaceTarget.replaceAll("\\\\","/"));

        for(int i=0; i<tabCount; i++)
            bw.append("\t");
        bw.append("public static final String "+varName+" = ");
        if(valueAlign){
            for(int i=0; i<varNameSpaces-varName.length(); i++) bw.append(" ");
            bw.append("\t"); }
        bw.append("\""+varValue+"\";\n");
    }


}