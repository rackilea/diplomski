put this line in first actvity.

Intent i=new Intent(First.this,second.class);
                i.putExtra("strin", "HI this is my text");
                startActivity(i);







and put this line in second activity 

Intent i=getIntent();
    String str=i.getStringExtra("strin");


declare both activity in manifest