import java.util.ArrayList;

 public class ObservatoryTest {

 private ArrayList <Earthquakes> listOfEarthquakes; //This list is not visible
    Earthquakes Quake1 = new Earthquakes(4.5,"cheese",1995);
    Earthquakes Quake2 = new Earthquakes(6.5,"fish",1945);
    Earthquakes Quake3 = new Earthquakes(10.5,"Chorizo",2015);

    public void buildList(Earthquakes... args){
        for(Earthquakes myEarthquake : args){
            listOfEarthquakes.add(myEarthquake);
        }

    }