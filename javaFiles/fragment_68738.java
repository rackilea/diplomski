@XmlRootElement(name="home")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class Customer  {

        @XmlElement(name="home_003")
        protected Date dateDebut;


        public Date getDateDebut() {
            return dateDebut;
        }

        public void setDateDebut(Date dateDebut) {
            this.dateDebut = dateDebut;
        }

    }