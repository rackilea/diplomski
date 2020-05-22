public class MyActivity extends BaseGameActivity implements IOnSceneTouchListener
{  
    private boolean hubIsClicked = false;

    private boolean touchMoveIsDone = false;

    public MyActivity( ... )
    {
        //blah
    }

    @Override  
    public boolean onSceneTouchEvent(Scene pScene, TouchEvent pSceneTouchEvent)  
    {  
       // Do something on scene touched event  
       return false;  
    } 
}