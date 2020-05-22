EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
            @Override public void handle(KeyEvent event) {
                if (KeyCode.TAB.equals(event.getCode())) {
                    if (lowThumb.isFocused()) {
                        if (event.isShiftDown()) {
                            lowThumb.setFocus(false);
                            new ParentTraversalEngine(rangeSlider).select(rangeSlider, Direction.PREVIOUS);
                        } else {
                            lowThumb.setFocus(false);
                            highThumb.setFocus(true);
                        }
                        event.consume();
                    } else if (highThumb.isFocused()) {
                        if(event.isShiftDown()) {
                            highThumb.setFocus(false);
                            lowThumb.setFocus(true);
                        } else {
                            highThumb.setFocus(false);
                            new ParentTraversalEngine(rangeSlider).select(rangeSlider, Direction.NEXT);
                        }
                        event.consume();
                    }
                }
            }
        };