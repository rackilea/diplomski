public class TheExample
{
  public TheExample()
  {
    final Timer timerOne = new Timer(speedOne, this::timerOneMethod);
    final Timer timerTwo = new Timer(speedTwo, this::timerTwoMethod);
  }

  private void timerOneMethod(ActionEvent e)
  {
    // do something exciting
  }

  private void timerTwoMethod(ActionEvent e)
  {
    // do something else exciting
  }
}