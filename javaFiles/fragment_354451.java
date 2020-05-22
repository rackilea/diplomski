Intent result=new Intent();

    result.putExtra("var1",data1);

    result.putExtra("var2", data2);

    setResult(Activity.RESULT_OK, result);

    finish();