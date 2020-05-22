try{

    String str = "rgb(105, 105, 105)";
    String splitStr = str.substring(str.indexOf('(') + 1, str.indexOf(')'));
    splitString = splitStr.split(",");

    int colorValues[] = new int[splitString.length];
    for (int i = 0; i < splitString.length; i++) {
        colorValues[i] = Integer.parseInt(splitString[i].trim());
    }

    int color = Color.rgb(colorValues[0], colorValues[1],colorValues[2]);
    view.setBackgroundColor(color); 

 }catch(Exception ex){

 }