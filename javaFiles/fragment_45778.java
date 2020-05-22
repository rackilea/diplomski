import java.util.LinkedList;
import java.util.List;

interface Handler {
    void handle(Chain chain);
}

interface Chain {
    void process();
}

class FirstHandler implements Handler {
    @Override
    public void handle(Chain chain) {
        System.out.println("first handler");
        chain.process();
    }
}

class SecondHandler implements Handler {
    @Override
    public void handle(Chain chain) {
        System.out.println("second handler");
        chain.process();
    }
}

class Runner implements Chain {
    private List<Handler> handlers;
    private int size = 5000; // change this parameter to avoid stackoverflowerror
    private int n = 0;

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.setHandlers();
        runner.process();
    }

    private void setHandlers() {
        handlers = new LinkedList<>();
        int i = 0;
        while (i < size) {
            // there can be different implementations of handler interface
            handlers.add(new FirstHandler());
            handlers.add(new SecondHandler());
            i += 2;
        }
    }

    public void process() {
        if (n < size) {
            Handler handler = handlers.get(n++);
            handler.handle(this);
        }
    }
}