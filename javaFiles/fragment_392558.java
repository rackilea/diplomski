@Entity
    public class TblPeopleContactInfo implements Serializable{
      private static final long serialVersionUID = 1L;

    @Id
    private int conId;

    @Column(name="con_phone_1")
    private String phone1;



     @OneToOne(optional=false)
     @JoinColumn( name="con_person_id_fk")
    @JsonIgnore
    private TblPeople tblPeople;


   public String getphone1() {
         return phone1;
    }

    public void setphone1(String phone1) {
        this.phone1 = phone1;
    }

      public TblPeople getTblPeople() {
        return tblPeople;
      }

    public void setTblPeople(TblPeople tblPeople) {
      this.tblPeople = tblPeople;
   } 

        public int getConId() {
        return conId;
      }

  public void setConId(int conId) {
       this.conId = conId;
   }


      public getFirstName(){
        return tblPeople.getFirstName();
        }
       // do the samething for rest of  variables
    public TblPeopleContactInfo(){

        }
     }