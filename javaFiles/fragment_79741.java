public class MainActivity extends AppCompatActivity
        implements SensorEventListener, ActivityCompat.OnRequestPermissionsResultCallback, CameraHelper{
    ...
    @Override
    public void fileSaved(String file){
        Intent intent = new Intent(this, AfterActivity.class);
        intent.putExtra("filePath", file);
        startActivity(intent);
        finish();
    }
}