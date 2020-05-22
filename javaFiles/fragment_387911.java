import java.util.ArrayList;
public class Lager {
private ArrayList<Screws> KreuzLagerort20kg,KreuzLagerort50kg;

public Lager(){
        //KreuzLagerort20kg = new ArrayList<Screws>();
        //KreuzLagerort50kg = new ArrayList<Screws>();

        fillLager(1, 20);
        fillLager(1, 50);
}

public void fillLager(int typ, int code){
     if (code==20){
         KreuzLagerort20kg = new ArrayList<Screws>();
     }
     if (code==50){
         KreuzLagerort50kg = new ArrayList<Screws>();
     }


     // code that loops through combinations and adds them to the arraylist
    }}}}}}