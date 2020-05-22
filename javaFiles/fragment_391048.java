import java.util.*;

class Comment {
    String id, String name;
    Date date;

    public Comment(String id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }
}


class CommentComparator implements Comparator<Comment> {
    public int compare(Comment o1, Comment o2) {
        return o1.date.compareTo(o2.date);
    }
}


class Test {
    public static void main(String[] args) {
        List<Comment> comments = new ArrayList<Comment>() {{
            long now = System.currentTimeMillis();
            add(new Comment("id1", "second", new Date(now)));
            add(new Comment("id2", "first", new Date(now - 1000)));
            add(new Comment("id3", "third", new Date(now + 1000)));
        }};

        Collections.sort(comments, new CommentComparator());
    }
}