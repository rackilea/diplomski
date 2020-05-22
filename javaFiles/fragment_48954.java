import javafxports.android.FXActivity;
import android.content.Context;
import java.io.File;

public class FileManager {
    private final Context context;

    public FileManager(){
        context = FXActivity.getInstance();
    }

    public File getFile(String fileName){
        return new File(context.getFilesDir(), fileName);
    }

}