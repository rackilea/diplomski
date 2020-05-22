public class TilePaneExample {

public javafx.scene.layout.TilePane listItems() {

    List<String> l = new ArrayList();
    l.add("C:/Users/Public/Music/Sample Music/Maid with the Flaxen Hair.mp3");
    l.add("C:/Users/Public/Videos/Sample Videos/Wildlife.wmv");
    l.add("C:/Users/Public/Pictures/Sample Pictures/Koala.jpg");
    l.add("C:/Users/Public/Pictures/Sample Pictures/Desert.jpg");

    // Pane
    javafx.scene.layout.TilePane tilePane = new javafx.scene.layout.TilePane();
    tilePane.setHgap(2);
    tilePane.setVgap(2);
    tilePane.setMinWidth(250);

    Image[] images = new Image[l.size()];
    ImageView[] pics = new ImageView[l.size()];

    //for (final String imageResource : l) { // removed first loop

        for (int i = 0; i < l.size(); i++) {

            final String imageResourceItem = l.get(i);
            images[i] = new Image("file:" + "C:/Users/Public/Pictures/Sample Pictures/Lighthouse.jpg");

            pics[i] = new ImageView(images[i]);
            pics[i].setFitWidth(22);
            pics[i].setPreserveRatio(true);
            pics[i].setSmooth(true);

            pics[i].setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    File f = new File(imageResourceItem);

                    String absolutePath = f.getAbsolutePath();
                    if (l.get(i).startsWith("file:")) { // changed the imageResourceItem into l.get(i)
                        absolutePath = absolutePath.replace("\\standAloneDev\\java\\workingDir\\live\\WakiliProject\\file:D:", "");
                    }

                    String ext = FilenameUtils.getExtension(absolutePath);

                    System.out.println("You clicked: " + absolutePath + ". The extension is: " + ext);
                    try {
                        Desktop.getDesktop().open(new File(absolutePath));

                    } catch (IOException ex) {
                        Logger.getLogger(TilePaneExample.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
            tilePane.getChildren().add(pics[i]);

        }
    }

    return tilePane;
//}