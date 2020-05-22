<%
Crypting c=new Crypting();
img=c.generateKey(w,h); // here specify type of the img object !!
/*Image img = c.generateKey(w,h); for example*/
encr=c.encrypt(img,src); // the same thing here 
%>