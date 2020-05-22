public void StartTurtle(int x) 
    { 
        points = x; 

        Turtle sue;
        sue = new Turtle(true, 200,90);
        sue.sleep(1000);
        sue.say("Something");
        sue.sleep(1000);
        sue.paint (90, 40); 
        sue.sleep(1000);
        sue.fillCircle(5);
        sue.sleep(1000);
        sue.fillBox(10, 20);

    } 

}