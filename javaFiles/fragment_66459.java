public class LamborghiniCarLot
{
private String lotName;
private ArrayList<Lamborghini> inventory;

public LamborghiniCarLot()
{
 ArrayList<Lamborghini> inventory = new ArrayList<Lamborghini>();
}

public LamborghiniCarLot(String lotName){
  ArrayList<Lamborghini>inventory = new ArrayList<Lamborghini>();
    setLotName(lotName);