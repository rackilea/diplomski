@Entity
@Table(name = "category")
public class FetchSubCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "parent_category_id")
    private FetchSubCategory mainCategory;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_EMPTY)//Avoiding empty json arrays.objects
    @OneToMany(mappedBy = "mainCategory", fetch = FetchType.EAGER)
    private List<FetchSubCategory> subCategory;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public FetchSubCategory getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(FetchSubCategory mainCategory) {
        this.mainCategory = mainCategory;
    }

    public List<FetchSubCategory> getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(List<FetchSubCategory> subCategory) {
        this.subCategory = subCategory;
    }