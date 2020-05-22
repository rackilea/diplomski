@Entity
public class Record {
    @Id
    private int id;
    @OneToOne(mappedBy="record", cascade={CascadeType.REMOVE})
    private RecordNotification notification;

    public Record(int id) {
        this.id = id;
    }

    protected Record() {}
}

@Entity
public class RecordNotification {
    @Id
    private int id;
    @OneToOne
    private Record record;

    public RecordNotification(int id, Record record) {
        this.id = id;
        this.record = record;
    }

    protected RecordNotification() {}
}