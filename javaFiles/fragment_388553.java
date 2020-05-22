public interface Sendable /* or Sender, SendingManager, etc. */ {
  public int getId();
  public void send();
}

public class EmailController implements Sendable {
}

public class SmsController implements Sendable {
}

public class Sendables {

 private Map<Integer, Sendable> sendables = new HashMap<Integer, Sendable>();

 public void addSendable(Sendable s) {
   this.sendables.put(s.getId(), s);
 }

 public void sendById(Integer id) {
   this.sendables.get(id).send();
 }

}