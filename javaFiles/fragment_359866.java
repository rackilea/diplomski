String[] imgarray={"img1","img2","img3","img4","img5","img6","img7"};
public static String PACKAGE_NAME ;
PACKAGE_NAME=getApplicationContext().getPackageName();
Random r = new Random();
int n=r.nextInt(imgarray.length());
int resID = getResources().getIdentifier( PACKAGE_NAME+":drawable/" +imgarray[n] , null, null);  
imageview.setImageResource(resID);