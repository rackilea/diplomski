Tile(int num, boolean f){
    imageNum=num;
    flipped=f;
    card=new JLabel(""+imageNum);//1. Remove this line and card Label
    super.setText(String.valueOf(num));//ADD This line
 }