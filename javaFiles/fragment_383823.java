switch(fileext){
case "jpg": ctype="image/jpg"; break;
case "gif": ctype = "image/gif"; break
default: 
ctype ="application/force-download";

}

header('Content-type: ' . $ctype);