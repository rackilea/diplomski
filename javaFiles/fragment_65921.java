public class Article implements IDedObject{
    private int articleID;
    private String articleName;
    private String authorName;

    // constructor and other getter and setter methods here

    @Override
    public int getID(){
        return articleID;
    }

    @Override
    public void printID(){
        System.out.println("" + articleID);
    }
}