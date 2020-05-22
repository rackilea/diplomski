public class MyActivity extends BaseGameActivity
{  
    private boolean hubIsClicked = false;

    private boolean touchMoveIsDone = false;

    public MyActivity( ... )
    {
       //example only
       addMyExampleListener( new IOnSceneTouchListener()
       {
          @Override  
          public void onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent)  
          {  
             //example only
             MyActivity.this.hubIsClicked = true;
          } 
       });
    }
}