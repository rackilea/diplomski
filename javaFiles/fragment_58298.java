@ManagedBean
@ApplicationScoped
public class ImgBean{
    @EJB
    private EJUser ejuser;

    @PostConstuct
    private void init(){
        // init some lists and objects from DB
    }

    private void onload(){
        init();        
    }

    public StreamedContent getChart(){
        //build and return 
    }
}