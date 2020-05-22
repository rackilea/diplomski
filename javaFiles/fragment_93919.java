@Entity
@Table(name="responses")
public class Response {
   ..................
   private PossResp possResp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resp_id") 
    public PossResp getPossResp() {
        return possResp;
    }
    ................

}