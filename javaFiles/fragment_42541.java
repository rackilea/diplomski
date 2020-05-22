@Component
public class MyPermissionEvaluator implements PermissionEvaluator {

    private final Log logger = LogFactory.getLog(getClass());

    @Override
    public boolean hasPermission(Authentication auth, Object arg1, Object arg2) {
        logger.info("hasPermission "+auth+" - "+arg1+" - "+arg2+" ");
        if(arg2 instanceof String && arg1 instanceof MyProject){
            MyProject project = (MyProject)arg1;
            if(((String) arg2).equals("read")){
                boolean result = hasPermissionReadProject(auth, project);                   
                return result;
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication arg0, Serializable arg1,
        String arg2, Object arg3) {
        logger.info("hasPermission "+arg0+" - "+arg1+" - "+arg2+" - "+arg3+" ");
        return false;
    }
}