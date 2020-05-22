imports ....

@FXMLController
public class MonitorPjeController {

    @FXML
    private TableView<Audiencia> audTable;

    @FXML
    private TableColumn<Audiencia, String> audId;

    @FXML
    private TableColumn<Audiencia, LocalDate> dataId;

    @FXML
    private TableColumn<Audiencia, String> assId;

    @FXML
    private ComboBox<Client> clientcomboBox;

    @FXML
    private Button BtnListaId = new Button();

    @FXML
    private Button BtnListarMaq;

    @FXML
    private ObservableList<Client> myClientComboBoxData = FXCollections.observableArrayList();

    @FXML
    private ObservableList<Audiencia> audData = FXCollections.observableArrayList();

    @Autowired
    private ClienteRepo clienteRepo;

    @FXML
    private void initialize() {

        populaTabela();

        Client client = new Client("teste123", "21 vt");

        // sets the combobox options
        myClientComboBoxData.add(client);
        myClientComboBoxData.add(new Client("cta122223", "10 vt"));
        myClientComboBoxData.add(new Client("cta122223", "17 vt"));
        myClientComboBoxData.add(new Client("cta120337", "18 vt"));

        clientcomboBox.setItems(myClientComboBoxData);

        clientcomboBox.setCellFactory((comboBox) -> {
            return new ListCell<Client>() {
                @Override
                protected void updateItem(Client item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(item.getVara());
                    }
                }
            };
        });

        clientcomboBox.setConverter(new StringConverter<Client>() {

            @Override
            public String toString(Client maquina) {
                if (maquina == null) {
                    return null;
                } else {
                    return maquina.getVara();
                }
            }

            @Override
            public Client fromString(String string) {
                // TODO Auto-generated method stub
                return null;
            }
        });

    }


    public void populaTabela() {
        audData.add(new Audiencia("12123123213213", LocalDate.now(), "sim"));
        audData.add(new Audiencia("22222222222222", LocalDate.now(), "nao"));
        audData.add(new Audiencia("22222222222222", LocalDate.now(), "nao"));
        audData.add(new Audiencia("55555555555555", LocalDate.now(), "sim"));
        audData.add(new Audiencia("6666666666666", LocalDate.now(), "nao"));
        audData.add(new Audiencia("7777777777777", LocalDate.now(), "nao"));
        audData.add(new Audiencia("8888888888888", LocalDate.now(), "sim"));
        audData.add(new Audiencia("99999999999999", LocalDate.now(), "nao"));
        audData.add(new Audiencia("100010110101001", LocalDate.now(), "nao"));


        audTable.setItems(getAudData());

        audId.setCellValueFactory(cellData -> cellData.getValue().processoProperty());
        dataId.setCellValueFactory(cellData -> cellData.getValue().dataProperty());
        assId.setCellValueFactory(cellData -> cellData.getValue().assinadoProperty());
    }

    public ObservableList<Audiencia> getAudData() {
        return audData;
    }

    public void setAudData(ObservableList<Audiencia> audData) {
        this.audData = audData;
    }

}