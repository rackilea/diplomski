if (console != null && dialog != null){
    throw new RuntimeException ("Both console and dialog were created."); 
}
else if (console != null){
    console.getInfo ("some String");

}
else if (dialog != null){
    dialog.getInfo ("some String");

}
else {
    throw new RuntimeException ("Both console and dialog were null."); 
}