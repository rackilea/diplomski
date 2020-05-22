@ManagedBean (name = TrainList.BEAN_NAME)
@SessionScoped
public class TrainList extends ListBasic<TrainObj> {    

    private static final long serialVersionUID = 1L;
    public static final String BEAN_NAME = "trainList";

    public TrainList ()  { super();}

    @ManagedProperty (value = "#{trainForm}")
    private TrainForm trainForm; //with getter&setter

    @PostConstruct
    private void setChildBeanProperty(){
        this.trainForm.setTrainList(this);
    }
}


@ManagedBean (name = TrainForm.BEAN_NAME)
@SessionScoped
public class TrainForm extends TrainObj {
    private static final Logger logger = Logger.getLogger(TrainForm.class.getName());
    public static final String BEAN_NAME = "trainForm";

    private TrainList trainList; /* + getter and setter */

    public TrainForm ()  {
        super();
    }

    public void refreshList(){
     if (trainList != null) {
            logger.debug(" trainlist is not null");
             trainList.refreshList();
        }
        else {
            logger.debug(" trainlist is NULL");
        }
}