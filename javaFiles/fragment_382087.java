protected void onDraw(Canvas canvas) {
    canvas.drawPath(path, paint);   
    try{            
         TextView v1 = (TextView) this.getRootView().findViewById(R.id.textView1);
         TextView v2 = (TextView) this.getRootView().findViewById(R.id.textView2);
         v1.setText("X: "+eventX);
         v2.setText("Y: "+eventY);
        }
        catch(Exception e1){
            Log.d("myError", e1);
        }
  }