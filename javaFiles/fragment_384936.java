String match ="";

for(File f: files){
   if(!match.isEmpty()) match+=",";
   match+=f.toString();
}
return match;