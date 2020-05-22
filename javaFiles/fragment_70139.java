@Entity
public class SomeEntity
{
    @ManyToMany
    @JoinTable(name = "entity_usage",
        joinColumns = @JoinColumn(name = "using_id"),
        inverseJoinColumns = @JoinColumn(name = "used_by_id"))
    private Set<SomeEntity> using = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "using")
    private Set<SomeEntity> usedBy = new LinkedHashSet<>();

    public void addUsing(SomeEntity entity)
    {
        this.using.add(entity);
        entity.usedBy.add(this);
    }

    public void addUsedBy(SomeEntity entity)
    {
        this.usedBy.add(entity);
        entity.using.add(this);
    }
}