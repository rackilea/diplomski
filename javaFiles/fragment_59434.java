public class Test {

    abstract static class EventObject {
        protected abstract void deliver(EventListener listener);
    }

    static class AEvent extends EventObject {
        @Override
        protected void deliver(EventListener listener) {
            listener.onAEvent(this);
        }
    }

    static class BEvent extends EventObject {
        @Override
        protected void deliver(EventListener listener) {
            listener.onBEvent(this);
        }

    }

    interface EventListener {
        void onAEvent(AEvent event);

        void onBEvent(BEvent event);
        // ...
    }

    private static final EventListener LISTENER = new EventListener() {
        @Override
        public void onBEvent(BEvent event) {
            System.out.println("Got B Event! " + event);
        }

        @Override
        public void onAEvent(AEvent event) {
            System.out.println("Got A Event! " + event);
        }
    };

    private static void notifyListeners(EventObject event) {
        event.deliver(LISTENER);
    }

    public static void main(String[] args) {
        notifyListeners(new AEvent());
        notifyListeners(new BEvent());
    }

}