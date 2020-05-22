public class ComponentController implements Initializable{

    private Entity entity;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
}