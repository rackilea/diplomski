public void paint(Graphics g){
    if(img != null)
        g.drawImage(img, 100, 100, this);
    else
        g.clearRect(0, 0, getSize().width, getSize().height);
}