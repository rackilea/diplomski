@Override   
public void paintComponent(Graphics g){     
    super.paintComponent(g);                 
    if (pics_to_be_drawn != null && !pics_to_be_drawn.isEmpty()) {
        g.drawImage(pics_to_be_drawn.get(0).Get_the_buf_img() , 41, 41, 59, 59, Color.black, null);
    }
}