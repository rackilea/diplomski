@Embeddable
public class Stems {
    // orphanRemoval removes stems which is present in database but not on list
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="word", orphanRemoval = true)
    private List<Stem> stems = new ArrayList<>();

    // getters/setters
}