public class Ball {

    public static final int FOOTBALL = 0;
    public static final int BASEBALL = 1;
    public static final int SOCCERBALL = 2;

    int ball;

     public Ball(){
        this.ball = Ball.FOOTBALL;
     }// end constructor

    /**
     *  Class constructor.
     *
     * @param ball sets the ball value.<p>
     * <b>ball</b> must be one of the following: Ball.FOOTBALL, Ball.BASEBALL,
     *             Ball.SOCCERBALL.
     */
     public Ball(int ball){          
        setBall(ball);       
     }// end constructor

     public int getBall(){
         return ball;
     }// end getBall()

     public void setBall(int ball){          
         switch(ball){           
         case 1:
             this.ball = Ball.BASEBALL;
             break;
         case 2:
             this.ball = Ball.SOCCERBALL;
             break;
         default:
             this.ball = Ball.FOOTBALL;
             break;          
         }// end switch          
     }// end setBall()       
}// end class Ball