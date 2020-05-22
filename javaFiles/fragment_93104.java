public class MyRealmObject extends RealmObject {
@PrimaryKey
String _id;

RealmList<?> replies;

//    public RealmList<?> getReplies() {
//        return replies;
//    } 
//
//    public void setReplies(RealmList<?> replies) {
//        this.replies = replies;
//    }