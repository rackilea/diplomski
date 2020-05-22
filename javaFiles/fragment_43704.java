import javafx.scene.image.ImageView;


public class tableDataModel {

private ImageView image;  

public tableDataModel(ImageView image){
    this.image = image;
}

public ImageView getImage(){
    return image; 
}

public void setImage(ImageView image){
    this.image = image;
}