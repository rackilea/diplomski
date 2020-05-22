String s="description: John Newman Logged on: 03.26.2018 9:26:29";
String log1 = null;

if(s.toLowercase().contains("logged on")){
    log1 = "Logged on"; // Your desired string
}else if(s.toLowercase().contains("logged off")){
    log1 = "Logged off"; // Your desired string
}