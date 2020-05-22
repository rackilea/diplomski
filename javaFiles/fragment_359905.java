for (int i = 0; i < 30; i++) {

  a[i] = new Button(this);
  a[i].setText(""+i);
  a[i].setId(i);
  a[i].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                                           LayoutParams.WRAP_CONTENT));
  a[i].setBackgroundResource(R.drawable.background);
 row.addView(a[i]);
}
layoutshape.addView(row);
}