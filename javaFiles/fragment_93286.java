int counter = 370;

@Override
public void actionPerformed(ActionEvent a)
{
    if (a.getSource()==up) {
        counter -= 62;         // this is where you change the value of counter

        System.out.println(counter);

        x=250+62+62;           // I have no idea what this is for
        y=60+62+62+62+62+62;   // or this, so I won't comment
        b1.setLocation(x,counter);   // just use the new counter value
        l19.setLocation(x,counter);
    }   
}