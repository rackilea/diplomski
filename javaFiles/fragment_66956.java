@Entity
public class Consumer {

    @OneToMany
    private List<Policy> policies;

}

@Entity
public class Policy {

}