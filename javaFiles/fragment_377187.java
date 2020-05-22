int from = originalString.lastIndexOf("<name>password</name><value>");
boolean endIteration = false;
for(i = from + 1 ; i < originalString.length() && !endIteration ; i ++) {
    if(originalString.toCharArray()[i] == '<')
        endIteration = true;
    else {
        originalString.toCharArray()[i] = '*';
    }
}