@FXML
public void HandleStartAction(){
    start();
}

public void run(){
    for(int n = 0; n < 100; n++){
        try {
            if(!suspend){
                Thread.sleep((long)TimeSlider.getValue() * 20);
                List.add(rand.nextInt(6) + 1);
                System.out.println(List.get(n));
            }else{

            }

        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }
}

public void start(){
    if (t == null)
    {
        t = new Thread (this, "Start");
        t.start ();

    }
}