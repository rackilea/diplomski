public class ButtonClickHandler implements View.OnClickListener {
    public void onClick(View view) {
       switch (view.getId()) {
             case R.id.imageView2:
                  Intent intent = new Intent(YourCurrentActivity.this, YourOtherActivity.class);
                  intent.putExtra("YourKeyName", "5");
                  startActivity(intent);
                  break;
             case R.id.imageView6:
                  Intent intent = new Intent(YourCurrentActivity.this, YourOtherActivity.class);
                  intent.putExtra("YourKeyName", "10");
                  startActivity(intent);
                  break;
             case R.id.imageView3:
                  Intent intent = new Intent(YourCurrentActivity.this, YourOtherActivity.class);
                  intent.putExtra("YourKeyName", "30");
                  startActivity(intent);
                  break;
             case R.id.imageView02:
                  Intent intent = new Intent(YourCurrentActivity.this, YourOtherActivity.class);
                  intent.putExtra("YourKeyName", "50");
                  startActivity(intent);
                  break;
             case R.id.imageView06:
                  Intent intent = new Intent(YourCurrentActivity.this, YourOtherActivity.class);
                  intent.putExtra("YourKeyName", "100");
                  startActivity(intent);
                  break;
             default:
                  break;
        }
   }
};

 String valueFromIntent = getIntent().getStringExtra("YourKeyName");

 Intent intent = new Intent(YourSecondActivity.this, YourThirdActivity.class);
 intent.putExtra("YourKeyName", valueFromIntent);
 startActivity(intent);