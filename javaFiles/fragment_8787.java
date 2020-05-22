public class User {
  public PublishSubject<User> stream = PublishSubject.create()
  public String userName;
  public String emailId;
  public List<Friend> friends;

  public User() {
    friends = new ArrayList<Friend>();
  }
  public void setName(String name){
         stream.onNext(this);
  }
}