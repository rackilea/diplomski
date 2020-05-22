pacakge project.eHealth ;

// imports omitted...

@Component
public class MainController {

    @Autowired
    private ApplicationContext context ;

    private Stage doctorStage;

    @FXML
    void showDoctorFrame() throws IOException{
        System.out.println("Handle regular User");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(EHealthApplication.class.getResource("DoctorView.fxml"));
        loader.setControllerFactory(context::getBean);
        Parent rootNode = loader.load();

        doctorStage = new Stage();
        doctorStage.setTitle("PatientView");
        Scene scene = new Scene(rootNode);
        doctorStage.setScene(scene);
        doctorStage.show();
    }

}