public class MyWidget extends LinearLayout {

  // Invoked by all of the constructors
  private void setup() {
    Context ctx = getContext();
    inflate(ctx, R.layout.content, this);
    ((TextView) findViewById(R.id.text)).setText(
        ctx.getString(R.string.hello_world)
    );
  }
}