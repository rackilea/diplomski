1. specify the drawable as a public static variable.

 2. Pass the drawable name as an intent extra and get the corresponding image whereever you want them.

//pass the image name
Intent i = new Intent(this, LivingActivity.class);  
i.putExtra("gender", gender);
startActivity(i);

Get corresponding image in onCReate() of LivingActivity

getResources().getDrawable(this.getIntent().getStringExtra("gender"));