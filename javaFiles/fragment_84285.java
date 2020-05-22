final Context context; /* get Context from somewhere */
final LinearLayout layout = (LinearLayout)findViewById(R.id.your_layout);
final RadioGroup group = new RadioGroup(context);
final RadioButton button1 = new RadioButton(context);
button1.setId(button1_id); // this id can be generated as you like.
group.addView(button1,
    new RadioGroup.LayoutParams(
        RadioGroup.LayoutParams.WRAP_CONTENT,    
        RadioGroup.LayoutParams.WRAP_CONTENT));
final RadioButton button2 = new RadioButton(context);
button1.setId(button2_id); // this id can be generated as you like.
button2.setChecked(true);
group.addView(button2,
    new RadioGroup.LayoutParams(
        RadioGroup.LayoutParams.WRAP_CONTENT,    
        RadioGroup.LayoutParams.WRAP_CONTENT));
layout.addView(group,
    new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,    
        LinearLayout.LayoutParams.WRAP_CONTENT));