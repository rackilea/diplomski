public class MainClass implements MongoSample {

public static void main(String[] args) {
    MainClass over = new MainClass();
    over.run();
}

public void run(){
    one();
}
@Override
public void two(String s){
    System.out.println("result : "+s);
}

}