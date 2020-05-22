import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//the vars that contains the users touch coords, I set some place holders the disapear as soon
//as the user touches the screen
private float touchX = 100;
private float touchY = 100;

//number of pixels to be moved every tick you should
//calculate them based on the screen size in a setup method
private int xSpeed = 10;
private int ySpeed = 10;

//bounds of the screen
private int leftBound;
private int rightBound;
private int topBound;
private int bottomBound;

//screen dimensions
private float pxScreenWidth;
private float pxScreenHeight;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);


    //make the scree go fullscreen
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);

    //remove action bar, and set content view
    setContentView(R.layout.activity_main);
    ActionBar actionBar = getSupportActionBar();
    actionBar.hide();

    //obtain the width and height of the screen in pixels
    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    pxScreenHeight = displayMetrics.heightPixels;
    pxScreenWidth = displayMetrics.widthPixels;

    //set bounds
    leftBound = 0;
    rightBound = (int) pxScreenWidth;
    topBound = 0;
    bottomBound = (int) pxScreenHeight;


    mainGame();
}

private void mainGame() {


    //some kind of timer I am lazy and used the countdown for this example
    //it does something every millisecond
    //first value is number of ticks second is the size 1 = 1ms 1000=1s
    new CountDownTimer(1000000, 1) {

        public void onTick(long millisUntilFinished) {

            //get the image view
            ImageView thing = (ImageView) findViewById(R.id.thing);
            int x = (int) thing.getX();
            int y = (int) thing.getY();


            moveThing(x, y, (int) touchX, (int) touchY);


        }

        public void onFinish() {

        }
    }.start();

}

private void moveThing(int xCoord, int yCoord, int targetX, int targetY) {

    //adjust these values to center
    ImageView thing = (ImageView) findViewById(R.id.thing);
    targetX = targetX - thing.getWidth() / 2;
    targetY = targetY - thing.getHeight() / 2;

    int width = thing.getWidth();
    int height = thing.getHeight();

    //for recording intended position
    int tempX = 0;
    int tempY = 0;

    //check so don't run if don't have to.
    if (xCoord != targetX) {
        boolean lessX = false;

        //set value to move forward
        int x = xCoord + xSpeed;

        //but if has to move backwards set the value to move backwards
        if (targetX < xCoord) {
            x = xCoord - xSpeed;
            lessX = true;

        }

        //if the amount of pixes goes over the target set it to the target
        if (lessX == false && x > targetX) {
            x = targetX;

        } else if (lessX == true && x < targetX) {
            x = targetX;

        }

        //check x bounds
        int temp = checkXBounds(x, width, leftBound, rightBound);
        if(temp != -1){
            x = temp;

        }

        //draw the thing in the new location
        if (xCoord < targetX || (xCoord > targetX && lessX == true)) {
            thing.setX(x);

        }
        tempX = (int) x;


    }

    //check so don't run if don't have to.
    if (yCoord != targetY) {

        //set value to move forward
        int y = yCoord + ySpeed;
        boolean lessY = false;

        //but if has to move backwards set the value to move backwards
        if (targetY < yCoord) {
            y = yCoord - ySpeed;
            lessY = true;

        }

        //if the amount of pixes goes over the target set it to the target
        if (y > targetY && lessY == false) {
            y = targetY;

        } else if (y < targetY && lessY == true) {
            y = targetY;

        }

        //check y bounds
        int temp = checkYBounds(y, topBound, bottomBound, height);
        if(temp != -1){
            y = temp;

        }

        //draw the thing in the new location
        if (yCoord < targetY || (yCoord > targetY && lessY == true)) {
            thing.setY(y);

        }

        tempY = (int) y;
    }


    TextView textView = (TextView) findViewById(R.id.coords);
    textView.setText("x: " + tempX + " " + "y: " + tempY);

}

private int checkXBounds(int xCoord, int width, int leftBound, int rightBound){

    if(checkLeftBound(xCoord, leftBound) == false){
        return leftBound;

    }
    if(checkRightBound(xCoord, rightBound, width) == false){
        return rightBound - width;

    }

    return -1;
}

private int checkYBounds(int yCoord, int topBound, int bottomBound, int height){

    if(checkTopBound(yCoord, topBound) == false){
        return topBound;

    }

    if(checkBottomBound(yCoord, bottomBound, height) == false){
        return bottomBound - height;

    }

    return -1;
}

private boolean checkLeftBound(int xCoord, int leftBound) {
    if(xCoord < leftBound){
        return false;

    }

    return true;
}

private boolean checkRightBound(int xCoord, int rightBound, int width){
    if(xCoord + width > rightBound){
        return false;

    }

    return true;
}

private boolean checkTopBound(int yCoord, int topBound){
    if(yCoord < topBound){
        return false;

    }

    return true;
}

private boolean checkBottomBound(int yCoord, int bottomBound, int height){
    if(yCoord + height > bottomBound){
        return false;

    }

    return true;
}


//gets touch coordinates and handles moving the ship
@Override
public boolean onTouchEvent(MotionEvent event) {

    //get the touch coordinates
    touchX = event.getX();
    touchY = event.getY();


    return super.onTouchEvent(event);

}

}