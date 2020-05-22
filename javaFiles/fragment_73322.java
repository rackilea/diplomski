Pitstop p = new Pitstop();
    Race r = new Race();
    new Thread(new Car("Ryan Hunter", r, p)).start();
    new Thread(new Car("Takumo Sato", r, p)).start();
    new Thread(new Car("Scott Dixon", r, p)).start();
    new Thread(new Car("Sebastien Bourdais", r, p)).start();
    r.StartRace();