switch (a){

case "one":                       
myLayout.removeView(rowView.findViewById(R.id.reps_layout));
break;

case "two":
LinearLayout layout =new LinearLayout(this);
    layout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
myLayout.addView(layout));
break;

default:
//myLayout.removeView(rowView.findViewById(R.id.reps_layout));
}