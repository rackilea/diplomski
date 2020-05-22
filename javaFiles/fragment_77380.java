int lastPos;
if(linkHref.indexOf("?") > 0) {
   lastPos = linkHref.indexOf("?");
} else if (linkHref.indexOf("&") > 0){
   lastPos = linkHref.indexOf("&");
}
else lastPos = -1;

if(lastPos != -1)
linkHref = linkHref.subsring(0, lastPos);