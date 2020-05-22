add2cart.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        boolean incart=false;
        String nm=name.getText().toString();
        mydb=Product_Details.this.openOrCreateDatabase("addcart", MODE_PRIVATE, null);
        System.out.println("Database Opened"); //here
        Cursor cur=mydb.rawQuery("select * from add2cart where pnme='"+nm+"'",null);
        System.out.println("Query Excuted"); //here
        if (cur.moveToFirst()){
            String prdname=cur.getString(cur.getColumnIndex("pnme"));
            System.out.println(prdname); //here
            if (nm.equals(prdname)){
                add2cart.setText("Already in Cart");
                incart=true;
            }
        }

        if(incart==false){
            mydb.execSQL("INSERT INTO add2cart (pnme,prate)VALUES('"+nm+"','"+prprice+"')");
            System.out.println("inserted"); //here
            Toast.makeText(getApplicationContext(),"add to cart",Toast.LENGTH_SHORT).show();
            Intent in=new Intent(Product_Details.this,add2cart.class);
            startActivity(in);

        }else{
            System.out.println("incart"); //here
        }

    }
});