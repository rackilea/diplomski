@Named("blogManager")
@SessionScoped
public class BlogManager {
    private List<Blog> blogs;

    private Blog blog;

    public BlogManager() {
        blogs = new ArrayList<Blog>();
            blog = new Blog();
    }

    // getter setters for blog and blogs

    public void addBlog() {
        blogs.add(blog);
    }

    public void removeBlog(Blog blog) {
        blogs.add(blog);
    }
}