public class Blog {

    private Integer id;

    private String title;
    private String text;
    private Date date;
    private Integer readed;

    public Blog() {
        id = (int) System.currentTimeMillis();
    }

    // getters-setters

}