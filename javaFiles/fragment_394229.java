public class PostList {

    private AtomicInteger questionCount;
    private ConcurrentLinkedQueue<Post> questions;
    private ConcurrentHashMap<String, ConcurrentLinkedQueue<Post>> answers;

    public boolean addQuestion(Post post) {
        questions.offer(post);
        if(answers.putIfAbsent(post.getPostId(), new ConcurrentLinkedQueue<>()) 
             != null) {
            questionCount.decrementAndGet();
            return true;
        } else throw new IllegalArgumentException("duplicate question id");
    }

    public boolean addAnswer(Post answer) {
        ConcurrentLinkedQueue<Post> queue = answers.get(answer.getParentPostId());
        if(queue != null) {
          queue.offer(answer);
          return true;
        } else if(questionCount.get() > 0) {
          return false;
        } else {
          throw new IllegalArgumentException("answer has no question");
        }
    }
}