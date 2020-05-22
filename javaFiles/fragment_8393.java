@Entity
    public class Characteristic implements Serializable {
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int id_characteristic ;
        private String name;
        private String description;
        private String type ;
        @ManyToOne
        @JoinColumn(name="id_machine")
        private Maschine maschine;
        public int getId_characteristic() {
            return id_characteristic;
        }
        public void setId_characteristic(int id_characteristic) {
            this.id_characteristic = id_characteristic;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getDescription() {
            return description;
        }
        public void setDescription(String description) {
            this.description = description;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public Maschine getMaschine() {
            return maschine;
        }
        public void setMaschine(Maschine maschine) {
            this.maschine = maschine;
        }
        public Characteristic() {
            super();
            // TODO Auto-generated constructor stub
        }

    }