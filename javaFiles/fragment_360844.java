public class SummController {

    private String name ;

    public String getName() {
        return name ;
    }

    public void initialize() {

        submit.setOnAction(e->{
            if (summfield.getText() == null || summfield.getText().trim().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Temp title");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a valid name!");
                alert.showAndWait();
            }else{
                try {

                    name = summfield.getText();

                    output = new FileOutputStream("config.properties");

                    prop.setProperty("name", name);

                    prop.store(output, null);

                    submit.getScene().getWindow().hide();

                } catch (IOException io) {
                    io.printStackTrace();
                } finally {
                    if (output != null) {
                        try {
                            output.close();
                        } catch (IOException a) {
                            a.printStackTrace();
                        }
                    }

                }

            }

        });
    }

}