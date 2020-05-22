public void onClick(View v){
    if(v.getId() == btn2.getId()){
        if(checkForMatch(btn2))
            result.setText("Correct!");
        else
            result.setText("Wrong!");
    }

    // Do what you need to for your other buttons
}