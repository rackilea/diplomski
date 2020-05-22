@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable(name = "film_actor", schema= "dvdrental", joinColumns = {
        @JoinColumn(name = "film_id", nullable = false, updatable = false) },
        inverseJoinColumns = { @JoinColumn(name = "actor_id",
                nullable = false, updatable = false) })
public Set<Actor> getActors() {
    return actors;
}

public void setActors(Set<Actor> actors) {
    this.actors = actors;
}