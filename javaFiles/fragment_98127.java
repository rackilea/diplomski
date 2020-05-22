package com.androidhive.androidlistview;

    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.widget.TextView;

    public class SingleListItem extends Activity{
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.setContentView(R.layout.single_list_item_view);

            ImageView productimage = (ImageView) findViewById(R.id.image);

            Intent i = getIntent();
            // getting attached intent data
            String product = i.getStringExtra("product");
            // displaying selected product name
            switch(product){
          case "item1":
              productimage.setImageDrawable(R.drawable.image1);
           break;
          case "item2":
              productimage.setImageDrawable(R.drawable.image2);
          break;
          case "item3":
              productimage.setImageDrawable(R.drawable.image3);
         break;
          .
          .
          .
          .
          .
//upto all 10 images

         }

        }
    }