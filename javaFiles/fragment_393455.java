import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Alert {

  private Context ctx;

  public Alert(Context ctx) {
    this.ctx = ctx;
  }

  public void show(String str) {
    build(str);
  }

  public void show(int str) {
    build(String.valueOf(str));
  }

  public void close(AlertDialog alert) {
    alert.dismiss();
  }

  private void build(String str) {
    AlertDialog.Builder builder = new AlertDialog.Builder(ctx);

    builder.setMessage(str);

    builder.setCancelable(false);
    builder.setTitle("Info");
    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int id) {

      }
    });

    AlertDialog alert = builder.create();
    alert.show();
  }
}