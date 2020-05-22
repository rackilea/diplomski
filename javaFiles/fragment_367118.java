/**
 * 
 *  encapsulates a player 
 * Class should be placed in session for web applications 
 */
public class Player
{
    String username ;
    String password ;

    // holds all the questions arranged for this player without allowing duplicates in questions 
    Set questions = new HashSet<Question>();

    // map this players question and answer 
    Map question_answers = new HashMap<Question, Answer>();


    /**
     * 
     *   Allows you to dynamically set questions for players 
     * @param questions_ 
     */
    public Player(Set questions_ )
    {
        this.questions = questions_;
    }


    // if you want the same set of questions for all players 
    public Player()
    {

     }

    /**
     * Question answered for this particular user 
     * please note that the player object is in session if it is a web application 
     * @param q
     * @param a 
     */
    public void answerQuestion(Question q , Answer a)
    {
        question_answers.put(q, a);
    }

    /**
     * 
     *  The user might go back to a previous question to change an answer 
     * @param q
     * @param a 
     */
   public void updateAnswer(Question q, Answer a)
    {
       // remove the question and update it with 
        if(question_answers.containsKey(q))
        {
            question_answers.remove(q);
        }


        // add the new q & a 
        answerQuestion(q, a);
    }

   /**
     * 
     *   finally save the players data 
     *   here your db model counts it would have to cater for 
     *  each players question and answer , send the batch update using batch prepared statements 
     */
    public void savePlayerData()
    {
        // db code is commented because i didnt write db codes 
        // status int the column will stand for correct or fail 
       // String save_sql =insert into results(player_id , question_id , answer , status) values(?,?,?,?)
        // PreparedStatement pstat = dbConnection.prepareStatement(save_sql);
        //dbConnection.setAutoCommit(false);
        // if automark is enabled 
        autoMark();
        Iterator it = question_answers.values().iterator();
        while(it.hasNext())
        {
            // fetch each question 
            Question q = (Question)it.next();
            // Fetch each answer based on the question 
            Answer a = (Answer)question_answers.get(q);

            int question_id = q.getQuestion_id();
            String answer = a.getAnswer();
            String answer_status = a.getStatus();
            /**
             *    
             *    
             *   commented cause i would have to write db backing code , lol !
             *    
             *    pstat.setInt(1, getUsername());
             *   pstat.setInt(2, question_id);
             *   pstat.setString(3 , answer);
             *  pstat.setString(4 , answer_status)
             * pstat.addBatch();
             * pstat.executeBatch();
             * 
             */

        }
        //dbConnection.setAutoCommit(false);

    }


    /**
     * 
     *   This method can allow your program to auto mark if 
     *   the question and answer  if it is based on a , b , c 
     */
    public void autoMark()
    {
        Iterator it = question_answers.values().iterator();
        while(it.hasNext())
        {
            // fetch each question 
            Question q = (Question)it.next();
            // Fetch each answer based on the question 
            Answer a = (Answer)question_answers.get(q);

            if(q.getQuestion_answer().equalsIgnoreCase(a.getAnswer()))
            {
                a.setStatus("Correct");
            }
            else
            {
                a.setStatus("Failed");
            }
            updateAnswer(q, a);
        }
    }

}