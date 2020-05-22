public class MainController {

    private static final double FADE_THRESHOLD = 80;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private AnchorPane rootPane;


    @FXML
    private VBox vBox;


    @FXML
    void initialize() {
        assert vBox != null : "fx:id=\"vBox\" was not injected: check your FXML file 'MainFXML.fxml'.";
        assert scrollPane != null : "fx:id=\"scrollPane\" was not injected: check your FXML file 'MainFXML.fxml'.";
        assert rootPane != null : "fx:id=\"rootPane\" was not injected: check your FXML file 'MainFXML.fxml'.";


        ArrayList<Label> labels = new ArrayList<>();

        for (int i = 0; i < 300; i++) {
            Label l = new Label("Label "+i);
            l.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
            labels.add(l);
        }

        labels.forEach( e-> vBox.getChildren().add(e));

        scrollPane.vvalueProperty().addListener(new ChangeListener<Number>() 
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
            {

                //System.out.println("bounds: "+getVisibleBounds(labels.get(51)));

                for(Label l: labels) {
                    Bounds bounds = getVisibleBounds(l);
                    double minY = bounds.getMinY();
                    double maxY = bounds.getMaxY();

                    if(Math.abs(minY) < FADE_THRESHOLD ) {
                        l.setOpacity(1-(FADE_THRESHOLD-Math.abs(minY))/FADE_THRESHOLD);
                    }else if(Math.abs(maxY) < FADE_THRESHOLD) {
                        l.setOpacity(1-(FADE_THRESHOLD-Math.abs(maxY))/FADE_THRESHOLD);
                    }else {
                        l.setOpacity(1);
                    }
                }
            }
        });
    }

    public static Bounds getVisibleBounds(Node aNode)
    {
        // If node not visible, return empty bounds
        if(!aNode.isVisible()) return new BoundingBox(0,0,-1,-1);

        // If node has clip, return clip bounds in node coords
        if(aNode.getClip()!=null) return aNode.getClip().getBoundsInParent();

        // If node has parent, get parent visible bounds in node coords
        Bounds bounds = aNode.getParent()!=null? getVisibleBounds(aNode.getParent()) : null;
        if(bounds!=null && !bounds.isEmpty()) bounds = aNode.parentToLocal(bounds);
        return bounds;
    }
}