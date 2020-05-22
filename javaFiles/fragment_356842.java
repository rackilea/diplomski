s_img = "img_test";//not "R.drawable.img_test" just the name of the image
if(getResources().getIdentifier(s_img, "drawable", getPackageName()) == imgs[0]){
   return true;
}else{
   return false;
}