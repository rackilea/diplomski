public class Table{

    private static Jframe frame;
    private static JTable table;

    public static void create(String name, double version, String author, int largeur, int hauteur){

        frame = new JFrame(String.format(name + " " + version + " by " + author));; // Not that I remove the declaration here to use the global variable