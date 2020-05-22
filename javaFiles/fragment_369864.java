Iterator<String> it = form.keySet().iterator();
while(it.hasNext()){
    String theKey = (String)it.next();
    System.out.println("Parameter Name - "+theKey+", Value - "+form.getFirst(theKey)); 
}
System.out.println(form);