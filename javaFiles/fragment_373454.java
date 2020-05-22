String[] src2=src.split("/");
String result="noting found !";

for(int i=0; i < src2.length; i++) {
   if( src2[i].contains("img") && (src2[i].contains(".png") || src2[i].contains(".jpg")/* more extensions */) ) { // add more extensions if needed
      result = src2[i];
      break;
   {
}

result = result.split(" ")[0]; //will cut at the first "space" and take only the "img.jpg" not the "width"

if(!result.equals("noting found !")) System.out.println("We found an image: "+result);