public class SimpleRandom {
/**
 * Test code
 */
public static void main(String[] args) {
    SimpleRandom rand = new SimpleRandom(10);
    for (int i = 0; i < 25; i++) {
        System.out.println(rand.nextInt());
    }

}

private int max;
private int last;

// constructor that takes the max int
public SimpleRandom(int max){
    this.max = max;
    last = (int) (System.currentTimeMillis() % max);
}

// Note that the result can not be bigger then 32749
public int nextInt(){
    last = (last * 32719 + 3) % 32749;
    return last % max;
}
}