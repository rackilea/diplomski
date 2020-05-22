@Entity
public class Consumer {

    public static enum ConsumerType {
        ACCOUNT, ORGANIZATION
    }

    @Enumerated(EnumType.STRING)
    @Column(name="consumer_type", nullable=false)
    private ConsumerType consumerType;

    // Other properties, getters/setters, ...
}