public class ResolverConsistencyChecker {

    private static Class checkClass = Jsps.class;
    private static String fullPathPrefix = "C:/Users/Foo/Desktop/myProject/web/WEB-INF/jsp/";


    public static void main(String[] args){
        try {
            filesChecker( checkClass );
            System.out.println( "Tests passed. All files locations are valid" );
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ResolverConsistencyChecker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResolverConsistencyChecker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // ================================================================================================ //
    // ============================================= WORK ============================================= //
    // ================================================================================================ //

    private static void filesChecker(Class rootClass) throws FileNotFoundException, IOException{

        // Check file paths in current class depth
        for(Field f : rootClass.getFields()){
            try {
                String fullFilePath = fullPathPrefix+f.get(f.getName()).toString();
                File file = new File( fullFilePath );
                if( !file.exists() )
                    throw new FileNotFoundException("Variable: '"+f.getName()+"'\nFile "+fullFilePath);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(ResolverConsistencyChecker.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ResolverConsistencyChecker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Check for embedded classes
        for(Class c : rootClass.getClasses()){
            filesChecker(c);
        }
    }

}