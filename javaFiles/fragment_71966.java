public class Media implements Comparable<Fruit> {
    public int compareTo(Fruit compareFruit) {

        int compareQuantity = ((Media) compareFruit).getSupporto(); 

        //ascending order
        return this.supporto - compareQuantity;

        //descending order
        //return compareQuantity - this.supporto;
    }
...
}