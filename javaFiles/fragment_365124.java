@Override
public void derepresent() {
    // you can drop this null-check when you're sure that mediaControl is set
    if(mediaControl != null) {
        parent.getChildren().remove(mediaControl);
    }
    mediaControl = null;
    mediaPlayer = null;
    media = null;
}