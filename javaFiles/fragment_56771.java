public class ScrollablePane extends Pane {
    private Integer scrollCounter = 0;

    private final ObjectProperty<EventHandler<? super ScrollEvent>> onScrollEnded = new SimpleObjectProperty<>();

    public final ObjectProperty<EventHandler<? super ScrollEvent>> onScrollEndedProperty() {
        return onScrollEnded;
    }

    public ScrollablePane() {
        this.setOnScroll(e -> {
            scrollCounter++;

            Thread th = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    if (scrollCounter == 1)
                        onScrollEnded.get().handle(e);

                    scrollCounter--;
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });
            th.setDaemon(true);
            th.start();
        });
    }

    public void setOnScrollEnded(EventHandler<? super ScrollEvent> handler) {
        onScrollEnded.setValue(handler);
    }
}