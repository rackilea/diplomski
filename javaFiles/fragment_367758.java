void cls() {
    // ???
}

void cls(String source){
    if(source.isEmpty()){
        source = "Unknown source";
    }
    output.setText("Screen cleared from " + source);
}