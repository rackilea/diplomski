ArrayList<String> stringList = new ArrayList<String>(); //Generic ArrayList to Store your Strings

stringList.add(et1.getText()) ;//do this for your 3 textviews  
stringList.add(et2.getText()) ;
stringList.add(et3.getText()) ;
int count=0;
Iterator<String> iterator = stringList.iterator();
    while (iterator.hasNext()) {
        count=count+Integer.parseInt(iterator.next());
    }