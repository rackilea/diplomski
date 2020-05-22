public void setBtn2Text(){
    switch(color.getCurrentTextColor()){
        case Color.GREEN:
            btn2.setText("Green");
        case Color.RED:
            btn2.setText("Red");
            break;
        // Continue for the other colors
    }
}