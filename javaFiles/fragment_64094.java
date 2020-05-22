public class MyView {
  int num;
  int currentState = 1; //much, much more pretty if you'd use Enum, 
                        //but I'll keep it simple now.

  public boolean onKeyDown(int key, KeyEvent event) {
    //no changes here
  }

  protected void setNum(){
    if(ray.size()==1)
        num=ray.get(0);
    else if(ray.size()==0)
        num=0;
    else
        num=(ray.get(0)*10)+ray.get(1);
    ray=new ArrayList<Integer>();
    if (currentState == 1) //(TODO:should really use Enum here....)
       part1();
    else if (currentState == 2)
       part2();
    else if (...
  }

  void part1() {
    addText("It is White's move");
    addText("Possible pieces to move");
    for(int x=0;x<b.getWhite().getPiecesWithMoves(b).size();x++)
    {
      addText(""+(x+1)+") "+b.getWhite().getPiecesWithMoves(b).get(x));
    }

    addText("Input the number of the piece you want to move");
    currentState = 2;//now we do nothing, we wait untill user finishes input
  }
  void part2()
  {//will be called after part1 finishes and a number has been entered
    p=a.num-1;
    if(p<b.getWhite().getPiecesWithMoves(b).size()&&p>=0) {
      gl=b.getWhite().getPiecesWithMoves(b).get(p).getLocation();
      addText("Possible moves");
      //and more code
      //Need input? stop and set next entry point
      currentState = 3;//continue to part 3
    }
    else
    {
      addText("Input the number of the piece you want to move");
      currentState = 2;//oops, stay at part2, we didn't get a good number!
    }
  }

}