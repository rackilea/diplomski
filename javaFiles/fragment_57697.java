Queue<int[]> q = new LinkedList();
int len = 3;

void setup() {
    for (int i = 0; i < len; i++) {
        int[] t = new int[1];
        t[0] = 5 - i;
        q.add(t);
    }

    for (int i = 0; i < len; i++) {
        print(q.remove()[0]);
        print(';');
    }
}