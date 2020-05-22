@Entity
public class Consumer {

    @OneToMany
    @JoinColumn("consumer_id")
    private List<Policy> policies;

}

@Entity
public class Policy {

}