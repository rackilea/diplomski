public class PlayerElementController {

    @FXML
    private Label songTime ;

    // note: might want to make the parameter a more appropriate type than string,
    // and perform the conversion to a string in this method...
    public void setSongTime(String songTime) {
        this.songTime.setText(songTime);
    }

    // and similarly here for the return type
    public String getSongTime() {
        return songTime.getText();
    }

    // ...
}