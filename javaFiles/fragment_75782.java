import java.util.Random;                                                     


public class MathGame {                                                      

  private int operand1;                                                      
  private int operand2;                                                      
  private int solution;                                                      

  public MathGame ()                                                         
  {                                                                          
    this.operand1 = getRandom();                                             
    this.operand2 = getRandom();                                             
  }                                                                          

  public int getRandom()                                                     
  {                                                                          
    Random rand = new Random();                                              
    int randNum = rand.nextInt(20);                                          
    return randNum;                                                          
  }                                                                          

  public int getoperand1()                                                   
  {                                                                          
    return operand1;                                                         
  }                                                                          

  public int getoperand2()                                                   
  {                                                                          
    return operand2;                                                         
  }                                                                          

  public String question()                                                   
  {                                                                          
    return "What is" + operand1 + " + " + operand2 + "?";                    
  }                                                                          

  public String solution()                                                   
  {                                                                          
    int solution = operand1 + operand2;                                      
    return "The correct answer is: " + solution;                             
  }                                                                          

}