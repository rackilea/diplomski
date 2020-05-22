Intent intent = new Intent();
intent.putStringArrayListExtra("foo",foo);
setResult(RESULT_OK, intent);



if (resultCode == RESULT_OK) {              //this does get called
Intent extras = this.getIntent();
foo = (ArrayList<? extends Object>)extras.getStringArrayListExtra("foo");

for (int i = 0; i < foo.size(); i++)    //error
    System.out.println(foo.get(i));