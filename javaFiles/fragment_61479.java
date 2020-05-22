public class Comment{

private Timestamp date;
private String description;
public static final Comparator<Comment> commentComparator = new MyComparator();

//getter and setter

static class MyComparator implements Comparator<Comment>{

            @Override
            public int compare(Comment o1, Comment o2) {
                // here you do your business logic, when you say where a comment is greater than other
            }    
}

}