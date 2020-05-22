public class ScrollContainer extends Region {

    private VerticalScrollBar scrollBar; // The scrollbar used for scrolling over the content from viewport
    private Rectangle rectangle; // Object for clipping the viewport to restrict overflowing content

    /**
     * Construct a new ScrollContainer
     */
    public ScrollContainer() {
        setOnScroll(evt -> {
            double viewportHeight = getHeight();
            double contentHeight = getContentHeight();
            if (contentHeight > viewportHeight) {
                double delta = evt.getDeltaY() / (viewportHeight - contentHeight);
                if (Double.isFinite(delta)) {
                    scrollBar.setValue(scrollBar.getValue() + delta);
                }
            }
        });

        scrollBar = new VerticalScrollBar();
        getChildren().add(scrollBar);

        rectangle = new Rectangle();
        setClip(rectangle);
    }

    private Node content;

    public void setContent(Node content) {
        if (this.content != null) {
            // remove old content
            getChildren().remove(this.content);
        }
        if (content != null) {
            // add new content
            getChildren().add(0, content);
        }
        this.content = content;
    }

    private double getContentHeight() {
        return content == null ? 0 : content.getLayoutBounds().getHeight();
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();

        double w = getWidth();
        double h = getHeight();

        double sw = scrollBar.getWidth();

        double viewportWidth = w - sw;
        double viewportHeight = h;

        if (content != null) {
            double contentHeight = getContentHeight();
            double vValue = scrollBar.getValue();

            // position content according to scrollbar value
            content.setLayoutY(Math.min(0, viewportHeight - contentHeight) * vValue);
        }

        // Layout scrollbar to the edge of container, and fit the viewport's height as well
        scrollBar.resize(sw, h);
        scrollBar.setLayoutX(viewportWidth);

        // resize clip
        rectangle.setWidth(w);
        rectangle.setHeight(h);
    }

    /**
     * VerticalScrollBar
     */
    private class VerticalScrollBar extends Region {

        private double initialValue;
        private double initialY; // Initial mouse position when dragging the scrubber
        private Timeline widthTransition; // Transforms width of scrollbar on hover
        private Region scrubber; // Indicator about the content's visible area

        private double value;

        public double getValue() {
            return value;
        }

        private double calculateScrubberHeight() {
            double h = getHeight();
            return h * h / getContentHeight();
        }

        /**
         * Construct a new VerticalScrollBar
         */
        private VerticalScrollBar() {
            // Scrollbar's initial width
            setPrefWidth(7);

            widthTransition = new Timeline(
                    new KeyFrame(Duration.ZERO, new KeyValue(prefWidthProperty(), 7)),
                    new KeyFrame(Duration.millis(500), new KeyValue(prefWidthProperty(), 14))
            );

            scrubber = new Region();
            scrubber.setStyle("-fx-background-color: rgba(0,0,0, 0.25)");
            scrubber.setOnMousePressed(event -> {
                initialY = scrubber.localToParent(event.getX(), event.getY()).getY();
                initialValue = value;
            });
            scrubber.setOnMouseDragged(event -> {
                double currentY = scrubber.localToParent(event.getX(), event.getY()).getY();
                double sH = calculateScrubberHeight();
                double h = getHeight();

                // calculate value change and prevent errors
                double delta = (currentY - initialY) / (h - sH);
                if (!Double.isFinite(delta)) {
                    delta = 0;
                }

                // keep value in range [0, 1]
                double newValue = Math.max(0, Math.min(1, initialValue + delta));
                value = newValue;

                // layout thumb
                requestLayout();
            });
            getChildren().add(scrubber);

            // Animate scrollbar's width on mouse enter and exit
            setOnMouseEntered(event -> {
                widthTransition.setRate(1);
                widthTransition.play();
            });
            setOnMouseExited(event -> {
                widthTransition.setRate(-1);
                widthTransition.play();
            });
        }

        @Override
        protected void layoutChildren() {
            super.layoutChildren();

            double h = getHeight();
            double cH = getContentHeight();

            if (cH <= h) {
                // full size, if content does not excede viewport size
                scrubber.resize(getWidth(), h);
            } else {
                double sH = calculateScrubberHeight();

                // move thumb to position
                scrubber.setTranslateY(value * (h - sH));

                // Layout scrubber to fit the scrollbar's width
                scrubber.resize(getWidth(), sH);
            }
        }
    }
}