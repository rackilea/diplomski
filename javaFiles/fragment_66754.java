public class PlayerTest {

public static void main(String[] args) {
    try {
        File f = new File("D:\\Musik\\Musik-Oberordner\\Favoriten\\06-ich_und_ich_-_so_soll_es_bleiben.mp3");
        MyPlayer player = new MyPlayer(new FileInputStream(f));
        player.setGain(-30f);
        player.play();
    } catch (JavaLayerException | FileNotFoundException ex) {
        ex.printStackTrace();
    }

}