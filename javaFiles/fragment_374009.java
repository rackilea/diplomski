public class PresentActivity extends Activity {
  protected void onCreate(Bundle icicle) {
    super.onCreate(icicle);

    setContentView(R.layout.content_layout_id);

    final Button button = (Button) findViewById(R.id.button_id);
    button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
              // Perform action on click   
              Intent activityChangeIntent = new Intent(PresentActivity.this, NextActivity.class);

              // currentContext.startActivity(activityChangeIntent);

              PresentActivity.this.startActivity(activityChangeIntent);
            }
          });
  }
}