public class QWithArray {

    String[] qItems;
    int front;
    int end;
    int current;

    QWithArray(int CAPACITY) {
        qItems = new String[CAPACITY];
        current = 0;
        front = -1;
        end = -1;
    }

    public void addqueue(String element) {
        if (current == qItems.length) {
            System.out.println("Item removed was: " + qItems[(front + 1) % qItems.length]);
        }

        front = (front + 1) % qItems.length;
        qItems[front] = element;
        current++;

        if (end == -1) {
            end = front;
        }
    }

    public String takequeue() {
        if (current == 0) {
            System.out.println("Queue is empty; can't remove.");
            return null;
        }

        String result = qItems[end];
        qItems[end] = null;

        end = (end + 1) % qItems.length;
        current--;

        if (current == 0) {
            front = -1;
            end = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        QWithArray q = new QWithArray(7);
        q.addqueue("a");
        q.addqueue("b");
        q.addqueue("c");
        q.addqueue("d");
        q.addqueue("e");
        q.addqueue("f");
        q.addqueue("g");
        System.out.println(Arrays.toString(q.qItems));

        q.addqueue("h");
        System.out.println(Arrays.toString(q.qItems));
    }
}