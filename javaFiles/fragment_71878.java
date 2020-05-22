public class MainActivity extends AppCompatActivity {

private VideoView vidView;
.
.
@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    switch (item.getItemId()) {

        case R.id.vidOne: {
            vidView.stopPlayback();
            videoUri = Uri.parse("http://www.mywebsite.com/vids/NewVideo.mp4");
            vidView.setVideoURI(videoUri);
            vidView.start();
            return true;

        case R.id.vidTwo:
            return true;

        case R.id.vidThree:
            return true;
    }
        return super.onOptionsItemSelected(item);
    }