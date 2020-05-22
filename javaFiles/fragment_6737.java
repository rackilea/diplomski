public class BaseActivity extends AppCompatActivity{

     @Override
     public void onPause(){
      //do things that common for all activities
     }
    }


public void MusicPlayActivity extends AppCompatActivity{

 @Override
 public void onPause(){
 music.mute()
 }
}