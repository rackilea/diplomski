@Data
@Entity
@Table(
    name = "notification_tags",
    uniqueConstraints = @UniqueConstraint(columnNames = "tag")
)
public class Tag {

    @Id
    @GeneratedValue
    @Column(name = "tag_id")
    private Long id;

    private String tag;

    @ManyToMany(mappedBy = "tags", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonBackReference
    private Set<Subscription> subscriptions = new HashSet<>();

    @ManyToMany(mappedBy = "tags", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JsonBackReference
    private Set<Notification> notifications = new HashSet<>();

    public Tag() {
    }

    @Builder
    public Tag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tag tag1 = (Tag) o;
        return Objects.equals(tag, tag1.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tag);
    }
}