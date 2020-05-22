public class MyApplication extends WebApplication {
    ...
    public void init() {
        ...
        final String resourceId = "images";
        getSharedResources().add(resourceId, new FolderResource(new File(getServletContext().getRealPath("img"))));    
        mountSharedResource("/image", Application.class.getName() + "/" + resourceId);
    }        
    ...
}