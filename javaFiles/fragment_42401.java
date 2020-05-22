@Entity
    @Access(FIELD)
    public class Message {

        @GeneratedValue(strategy = AUTO)
        @Id
        private Long id;       

        @ManyToOne
        private User fromUser;
        @ManyToOne
        private User toUser;
    }