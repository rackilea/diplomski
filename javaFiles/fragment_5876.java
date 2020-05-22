@IdClass(CopositeKey.class)
 public class Event {
        @Id
        private String name;

        private String description;

        @Id
        private Date eventDateTime;

        //getter and setter code
    }