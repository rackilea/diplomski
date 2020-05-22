1. remove  android:onClick="onClickViaMain" from favicon imageView to avoid crash from xml layout

2. MainActivity extends AppCompatActivity implements View.OnClickListener {

@Override
public void onClick(View v) {
           // handle click  
      }            

// other code 
} 


3. public class GridAdapter extends BaseAdapter {
// other code 
View.OnClickListener listener;
public GridAdapter(Context context,View.OnClickListener listener){

    this.listener=listener;
    this.context=context;
    this.letters=letters;
    this.images=images;
}
// other code here

Inside getView Method of your Adapter do like below 

    // images on the gridView (Android icon)
    ImageView favicon=(ImageView) gridView.findViewById(R.id.favicon);

    favicon.setImageResource(images[position]);
    **favicon.setOnClickListener(listener);**



4. In Main Activity update line 

    gridAdapter=new GridAdapter(MainActivity.this);

    gridAdapter=new GridAdapter(MainActivity.this,MainActivity.this);


// because we implemented OnclickListener in MainActivity  and we are done