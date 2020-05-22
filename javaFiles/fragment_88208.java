public int getWidth() {
DisplayMetrics displayMetrics = new DisplayMetrics();
getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
int width = displayMetrics.widthPixels;
return width;
}


public void setLayoutMargins() {

View layout = findViewById(R.id.relative);
RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(layout.getLayoutParams());
layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
layoutParams.topMargin = 400;
layout.setLayoutParams(layoutParams);

//ImageView Layout
View image = findViewById(R.id.imgage);
LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(image.getLayoutParams());
image.getLayoutParams();
imageParams.width = 800;
imageParams.height = 600;
image.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
image.setLayoutParams(imageParams);

//UpperTable Layout
View upperTable = findViewById(R.id.upperTableLayout);
LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(upperTable.getLayoutParams());
params.leftMargin = 250;
params.topMargin = 160;
upperTable.setLayoutParams(params);

}


public void setTextSizes() {

txt1 = findViewById(R.id.item_1);
txt2 = findViewById(R.id.item_2);
txt3 = findViewById(R.id.item_3);
txt4 = findViewById(R.id.item_4);
txt5 = findViewById(R.id.item_5);
f_item_1 = findViewById(R.id.f_item_1);
f_item_2 = findViewById(R.id.fl_item_2);
t1_item_1 = findViewById(R.id.t1_item_1);
tempo_item_1 = findViewById(R.id.tempo_item_1);
t2_item_2 = findViewById(R.id.t2_item_2);
tempo_item_2 = findViewById(R.id.tempo_item_2);
n_cancellature = findViewById(R.id.n_cancellature);
n_3 = findViewById(R.id.n_3);
txtSenza = findViewById(R.id.txtSenza);
txtUpper = findViewById(R.id.upperTableHeader);
txtLower = findViewById(R.id.lowerTableHeader);

txt1.setTextSize(30);
txt2.setTextSize(30);
txt3.setTextSize(30);
txt4.setTextSize(30);
txt5.setTextSize(30);
f_item_1.setTextSize(30);
f_item_2.setTextSize(30);
txtSenza.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
txtLower.setTextSize(30);
txtUpper.setTextSize(30);
t1_item_1.setTextSize(30);
t2_item_2.setTextSize(30);
tempo_item_1.setTextSize(30);
tempo_item_2.setTextSize(30);
n_3.setTextSize(30);
n_cancellature.setTextSize(30);

}