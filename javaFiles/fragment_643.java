Subselect(
    "SELECT * from table1" 
)
@Entity
@Immutable
class Entity {
    @OneToMany
    @JoinColumn(name = "field", updatable = false, insertable = false)
    private Set<Table2Entity> elements = new HashSet<>();
}