String tag = "";
if(line.startsWith("@public")){
   tag = "@public";
}else if{....other tags....}

line = line.substring(tag.length(), line.indexOf(";")).trim();