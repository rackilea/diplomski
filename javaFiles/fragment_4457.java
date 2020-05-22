class MyPanel extends JPanel{
    private ArrayList<City> tempCity;
    private ArrayList<City> tempCity2;

    int delay = 5000;   // 5 sec delay.
    int interval = 1000;  // 1 sec interval.
    Timer timer;

    public MyPanel(){
      timer = new Timer();

      timer.scheduleAtFixedRate(new TimerTask() {
        public void run() {
            doGA();
        }
      }, delay, interval);
    }

    public void doGA(){
            tempCity = new ArrayList<City>();
            tempCity2 = new ArrayList<City>();
            City city = new City(60, 200);
            TourManager.addCity(city);
            City city2 = new City(180, 200);
            TourManager.addCity(city2);
            City city3 = new City(80, 180);
            TourManager.addCity(city3);
            City city4 = new City(140, 180);
            TourManager.addCity(city4);
            City city5 = new City(20, 160);
            TourManager.addCity(city5);
            City city6 = new City(100, 160);
            TourManager.addCity(city6);
            City city7 = new City(200, 160);
            TourManager.addCity(city7);
            City city8 = new City(140, 140);
            TourManager.addCity(city8);
            City city9 = new City(40, 120);
            TourManager.addCity(city9);
            City city10 = new City(100, 120);
            TourManager.addCity(city10);
            Population population = new Population(50, true);
            for(int i = 0; i<10; i++){
                for(int x2 = 0; x2<9;x2++){
                    tempCity.add(population.getFittest().getCity(x2));
                    tempCity2.add(population.getFittest().getCity(x2+1));
                    repaint();
                }
                population = GA.evolvePopulation(population);
                repaint();
                System.out.println(population.getFittest().getFitness());
            }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        for(int i=0; i<tempCity.size(); i++){ //Assuming tempCity size = tempcity 2 size (worst way ever)
            g2.fillOval(tempCity.get(i).getX(), tempCity.get(i).getY(), 10, 10);
            g2.drawLine(tempCity.get(i).getX(),tempCity.get(i).getY() , tempCity2.get(i).getX(), tempCity2.get(i).getY());
        } 
    }
}