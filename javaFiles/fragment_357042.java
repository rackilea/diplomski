@Entity
@Table(name = "lazy_child")
public class LazyChild {
    [...]  

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "file_id")
    private File file;
}