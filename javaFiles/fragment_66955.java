@Entity
public class Consumer {

    @OneToMany(mappedBy = "consumer")
    private List<Policy> policies;

}

@Entity
public class Policy {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn("consumer_id")
    private Consumer consumer;

}