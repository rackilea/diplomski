public class Question {

   static int keyCount; 

   public Question(String que, String[] ans, int sol, double prio){
      this.question = que;
      this.answers = ans;
      this.solution = sol;
      this.priority = prio;
      Database.put(++keyCount, this);
   }

}