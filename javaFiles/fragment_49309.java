boolean found=false;
for(String unparsedTargets : commandline.getArgs()){
    if("file.txt".equals(unparsedTargets)){
        found =true;
    }
}
if(!found){
    throw new IllegalArgumentException("must provide a file.txt");
}