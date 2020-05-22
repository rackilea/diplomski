public class Math {

private int num;
private int numTotal;
private int mean;
private int counter;

/*public Math(int num, int numTotal){
this.num = num;
}*/

public Math(int num, int counter) {
    this.num = num;
    this.counter = counter;
}

//get//
public int getNum(){
    return this.num;
}

public int getNumTotal(){
    return this.numTotal;
}

public int getCalcMean(){
    mean = numTotal / this.counter;
    return mean;
}

public int getCounter(){
    return this.counter;
}

//set//

public void setNumTotal(int value){
    this.numTotal = value;
}

public void setNum(int value){
    this.num = value;
}

public void setCalcMean(int value){
    this.mean = value;
}

public void setCounter(int counter){
    this.counter = counter;
}

//other
/*public void adder(int num){
numTotal = numTotal + num;
}*/

public void adder(int num) {
    this.num = num;
    numTotal = numTotal + this.num;
}
//added after//
public void calcMean(int num){
    mean = numTotal / this.counter;
}
}