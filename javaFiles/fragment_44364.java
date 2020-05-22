Log.v("Sending data to Detail","hi "+biz);
        //startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(biz.url)));
        Intent intent = new Intent(getApplicationContext(), YelpBizDetail.class);
       // Intent intent = new Intent(YelpSearch.this,YelpBizDetail.class).putExtra("myCustomerObj",biz);
        intent.putExtra("Detailclass",biz);

        Log.v("Sending data to Detail","sent "+biz);