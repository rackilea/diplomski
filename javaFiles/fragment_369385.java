if(aantal>5 || aantal<0){
    showMessageDialog(null, "Geef een getal tussen 1 en 5 in!");
     repaint();
}
int counter = (vallen) ? 0:1;
int x1=30,y1=300;
int x2=50,y2=290;
int randomVal=new Random().nextInt(aantal);
while(counter<=aantal){
        if(counter!=randomVal){
            g.setColor(kleur);
            g.fillOval(x1, y1, 40, 40);
            g.setColor(Color.black);
            g.fillRect(x2, y2, 5, 10);
            x1=x1+60;
            x2+=60;
            y1+=10;
            y2+=10;
         }else{
            //write code for fallen apple
         }
 }