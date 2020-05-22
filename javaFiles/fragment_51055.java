public class AwesomePolicy extends Policy {
    private PermissionCollection myPermissions;
    private List<Path> inputPaths;
    private List<Path> processPaths;

    public AwesomePolicy(List<Path> inputPaths, List<Path> processPaths){
        this.inputPaths=inputPaths;     // shallow copy
        this.processPaths=processPaths; // shallow copy
        myPermissions = new AwesomePermissionCollection();
        populateAwesomePermissionCollection();
    }

    @Override
    public PermissionCollection getPermissions(CodeSource codesource){
    return permissions;
    }

    private void populateAwesomePermissionCollection(){
        for(Path p : inputPaths){
            myPermissions.add(new FilePermission(p.toString() + File.separatorChar + "*", "read, write");

        for(Path p: processPaths){
            myPermissions.add(new FilePermission(p.toString() + File.separatorChar + "*", "read, write");
    }
  }
}


public AwesomePermissionCollection extends PermissionCollection{

     private static final long serialVersionUID = -7456927975079431927L;

     List<Permission> myPermissions = new ArrayList<Permission>();

    @Override
    public void add(Permission p){
        myPermissions.add(p);
    }

    @Override
    public Enumeration<Permission> elements(){
        return Collections.enumeration(myPermissions);
    }

    @Override
    public boolean implies(Permission permission){
        for(Permission p: myPermissions){
            if(p.implies(permission)){
                return true; 
            }
        }
            return false;
    }
}