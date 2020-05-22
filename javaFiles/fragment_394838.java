public interface YourInterface {
 int getId();
 int getType();
}

// implement this interface in your classes
public class PostResult  implements YourInterface {

 // Your class code here

 @Override
 public int getId() {
  return this.get_id();
 }

 @Override
 public int getType() {
  return this.getType();
 }
}

public class BBPostLikeLogs implements YourInterface {

  // Your class code here

  @Override
  public int getId() {
   return this.getId_post();
  }

  @Override
  public int getType() {
   return this.getType();
  }
}

// and finally the loop

for (YourInterface detail : bbPostLikeLogs) {
  if (detail.getType() == 4) {
   NewFaqQuestion questions = newFaqQuestionRepository.findByIdQuestion(detail.getId());
   if (questions == null) continue;
   listObjPosts.add(buildObjPostFromQuestions(questions,userAuth));
  } else {
   BBPost bbPost = bbPostRepository.findById(detail.getId());
   if(bbPost == null) continue;
   listObjPosts.add(buildObjPostFromPosts(bbPost,userAuth));
  }
}