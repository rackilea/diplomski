OutputStream oos;    
if(_param.get("opath") != null) {
    oos = new FileOutputStream(_param.get("opath").toString());
} else {
    oos = csocket.getOutputStream();
}
//do something with oos