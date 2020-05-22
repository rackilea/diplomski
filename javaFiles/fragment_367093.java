@Override
public void run() {
    int x = 0;
    int count = 0;
    while (++count < 69) {
        x = buffer.take();
        System.out.println(x);
    }
}