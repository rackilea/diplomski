@Data
@AllArgsConstructor
public class ExternalActionReqBean<T> {

   private String txnID;
   private String action;
   private String resource;
   private T payload;

}