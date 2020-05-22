//passing id to tab #1
    Intent passing1 = new Intent();
    Bundle bundle = getIntent().getExtras();
    String id=bundle.get(ID_USER).toString();   
    passing1.putExtra("iduser", id);
    passing1.setClass(this, Input_form.class);

    TabHost host = getTabHost();
    host.addTab(host.newTabSpec("one").setIndicator("ADD NEW DATA")
            .setContent(passing1));

    //passing idkont to tab #2

    Intent passing2 = new Intent();
    Bundle bundle2=getIntent().getExtras();
    String id2 = bundle2.get(ID_USER).toString();
    passing2.putExtra("iduser", id2);
    passing2.setClass(this, MyData.class);



    host.addTab(host.newTabSpec("two").setIndicator("MY DATA")
            .setContent(passing2));