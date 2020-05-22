import android.content.Context;

import java.io.IOException;
import java.util.Scanner;

public class WLTPc {

    private Context context;

    public WLTPc(Context context) {
        this.context = context;
    }

    public int[] readAssetFiles(String file) {
        try {
            Scanner s = new Scanner(context.getAssets().open(file));
            int ctr = 0;
            while (s.hasNextInt()) {
                ctr++;
                s.nextInt();
            }
            s.close();
            int[] arr = new int[ctr];

            Scanner s1 = new Scanner(context.getAssets().open(file));

            for (int i = 0; i < arr.length; i++) {
                arr[i] = s1.nextInt();
            }
            s1.close();
            return arr;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}