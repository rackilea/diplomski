package com.my.imagechange;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ImageChange extends Activity
{

private Gallery gallery;
private ImageView imgView;
private ImageButton btlt,btrt;
private Integer[] Imgid= {
        R.drawable.androidlogo, R.drawable.androids, R.drawable.cool, R.drawable.cupcake2009, R.drawable.donut2009, R.drawable.eclair2009};
int imglength=Imgid.length;

int img_position;
int img_minus;
int img_plus;
@Override
public void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    imgView = (ImageView)findViewById(R.id.ImageView01);    
    imgView.setImageResource(Imgid[0]);

    btlt=(ImageButton)findViewById(R.id.bt1);
    btrt=(ImageButton)findViewById(R.id.bt2);

    System.out.println("----->"+imglength +"----->");
     btlt.setOnClickListener(new View.OnClickListener() 
    {

        @Override
        public void onClick(View v)
        {

            // TODO Auto-generated method stub
            btrt.setEnabled(true);
            System.out.println("left button has been clicked");
            System.out.println("position: "+img_position);
            img_minus=--img_position;
            System.out.println("minus:"+img_minus);
             imgView.setImageResource(Imgid[img_minus]);
             //imgView.setBackgroundDrawable(getResources().getDrawable(id));
             if(img_minus==0)
             {
                btlt.setEnabled(false);
             }


        }
    });

     btrt.setOnClickListener(new View.OnClickListener()
     {
        @Override
        public void onClick(View v) 
        {

            // TODO Auto-generated method stub
            btlt.setEnabled(true);
            System.out.println("right button has been clicked");
            System.out.println("position: "+img_position);
            img_plus=++img_position;
            System.out.println("plus: "+img_plus);
             imgView.setImageResource(Imgid[img_plus]);
            if(img_plus==5)
             {
                btrt.setEnabled(false);
             }

        }
    });


} }