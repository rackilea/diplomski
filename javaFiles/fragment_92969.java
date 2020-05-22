public void setColor(){
    if(color.equals(CYAN)){
        setBackground(Color.decode(DARKGRAY));
        color = DARKGRAY;
    }
    else{
        setBackground(Color.decode(CYAN));
        color = CYAN;
    }
}