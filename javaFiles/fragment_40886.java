function decreaseTime(score:Int)
{
  var time:float = 500 * (1/score)
  //ap from your other code
  _t1.stop(); //<---- member variable
  _t1 = new Timer(time, ap);
  _t1.start();
}