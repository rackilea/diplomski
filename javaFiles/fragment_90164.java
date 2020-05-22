@Entity
@Table(name = "categories")
public class Category {

    @Id
    @Column(name = "categoryid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long categoryId;

    @Column(name = "categoryName")
    private String categoryName;

    @Column(name = "createdDate")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Category> subCategories = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    private Set<Post> posts = new HashSet<>();

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(String categoryName, Date createdDate, Category parentCategory, Set<Category> subCategories, Set<Post> posts) {
        this.categoryName = categoryName;
        this.createdDate = createdDate;
        this.parentCategory = parentCategory;
        this.subCategories = new HashSet<>();
        if (parentCategory != null) {
            parentCategory.subCategories.add(this);
        }
        this.subCategories = subCategories;
        this.posts = posts;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(Set<Category> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return categoryId == category.categoryId;

    }

    @Override
    public int hashCode() {
        return (int) (categoryId ^ (categoryId >>> 32));
    }