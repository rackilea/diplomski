@Override
public void actionPerformed(ActionEvent a)
{
    int counter=370;

    if (a.getSource()==up) {
        System.out.println(counter);

        x=250+62+62;
        y=60+62+62+62+62+62;
        b1.setLocation(x,counter-62);
        l19.setLocation(x,counter);
    }   
}