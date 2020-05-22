import android.annotation.TargetApi;
import android.os.Build;
import android.service.quicksettings.TileService;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.N)
public class TileServ extends TileService {

@Override
public void onDestroy(){
    super.onDestroy();
}

@Override
public void onTileAdded(){
    super.onTileAdded();
}

@Override
public void onTileRemoved(){
    super.onTileRemoved();
}

@Override
public void onStartListening(){
    super.onStartListening();
}

@Override
public void onStopListening(){
    super.onStopListening();
}

@Override
public void onClick(){
    super.onClick();
    Toast.makeText(getApplicationContext(), "HI", Toast.LENGTH_LONG).show();
}
}