public class Behavior{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private Long id;

        @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="behavior")
        @JsonIgnore
        private List<BehaviorEvent> events = new LinkedList<>();

        public void addEvent(BehaviorEvent event) {
            if (event != null) {
                if (events == null) {
                    events = new ArrayList<>();
                }

                if (event.getBehavior() == null)
                    event.setBehavior(this);

                events.add(event);
            }
        }
    }