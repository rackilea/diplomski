if(feedCountFromDB > feedCountFromUI){
  //Send your json variable (result) to your jquery post callback
  out.println(result);
} else {
  //Means there is nothing new, print 0
  out.println(0);
}