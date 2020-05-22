import com.techtalix.util.Const;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Test extends Application {

Connection connect = null;

public static void main(String[] args) {
    launch(args);
}

@Override
public void start(Stage stage) {

    List<ImageDataObjs> imageURLs = null; //you'll use something like this, but I've not for this little helper
    //here you'll want to make a database setup and a call: This is a really bad program, but it will demonstrate
    connectToDB();
    imageURLs = makeDBCall();

    GridPane root = new GridPane();
    Scene theScene = new Scene(root);
    stage.setTitle("Some scene");
    stage.setScene(theScene);

    root.setPadding(new Insets(10,10,10,10));
    root.setHgap(10);
    root.setVgap(10);

    int cols=2, colCnt = 0, rowCnt = 0;
    for (int i=0; i<imageURLs.size(); i++) {
        root.add(imageURLs.get(i).imageView, colCnt, rowCnt);
        colCnt++;
        if (colCnt>cols) {
            rowCnt++;
            colCnt=0;
        }
    }


    // in terms of auto update, instead of gridpane, I suggest you look into TableView, and cell factories.
    // once you have bound your cell factories, you can make calls to your DB, and the values bound will update automatically
    //http://www.java2s.com/Tutorials/Java/JavaFX/0650__JavaFX_TableView.htm

    stage.initStyle(StageStyle.UNDECORATED); //remove this is you want to see the title bar etc.
    stage.show();
}

class ImageDataObjs {
    final ImageView imageView;
    String imgURL, price;

    public ImageDataObjs(String imgURL, String price) {
        this.imgURL = imgURL;
        this.price = price;
        Path imagePath = Paths.get(imgURL);
        File imageFile = imagePath.toFile();
        Image image = new Image(imageFile.toURI().toString());
        this.imageView = new ImageView(image);
    }
}

//there a million examples of theis on the web
private List<ImageDataObjs> makeDBCall() {
    List<ImageDataObjs> imageDataObjList = new ArrayList<>();
    String myPrice, myURL;
    try {

        Statement statement = connect.createStatement();
        ResultSet resultSet = statement
                .executeQuery("select * from myProductList"); //you need to have a table called myProductList in your database

        while (resultSet.next()) {
            myPrice = resultSet.getString("myImageURL"); //these are the SQL cols that you should have already created in your database
            myURL = resultSet.getString("somePriceData");
            imageDataObjList.add(new ImageDataObjs(myURL, myPrice));
        }
        connect.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    /*
    JUST FOR EXAMPLE - this would come from your database query
     */

    imageDataObjList.add(new ImageDataObjs(Const.BASE_DIRECTORY + "png/bridge.png", "1.99"));
    imageDataObjList.add(new ImageDataObjs(Const.BASE_DIRECTORY + "png/bridge.png", "2.99"));
    imageDataObjList.add(new ImageDataObjs(Const.BASE_DIRECTORY + "png/bridge.png", "3.99"));
    imageDataObjList.add(new ImageDataObjs(Const.BASE_DIRECTORY + "png/bridge.png", "4.99"));
    imageDataObjList.add(new ImageDataObjs(Const.BASE_DIRECTORY + "png/bridge.png", "5.99"));
    imageDataObjList.add(new ImageDataObjs(Const.BASE_DIRECTORY + "png/bridge.png", "6.99"));
    imageDataObjList.add(new ImageDataObjs(Const.BASE_DIRECTORY + "png/bridge.png", "6.99"));

    return imageDataObjList;
}

private void connectToDB() {
    //Note: you'll still it in tutorials, but Class.forName() is not needed since JDBC 4.0.
    //make sure but this point that MYSQL is installed, and that ConnectorJ is also installed.
    //create a database called "someDatabase" - make sure user and password are are you installed them.
    try {
        connect =
                DriverManager.getConnection("jdbc:mysql://localhost/someDatabase" +
                        "?user=root&password=root");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}