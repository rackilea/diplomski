circle.setOnDragDetected(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    Dragboard db = circle.startDragAndDrop(TransferMode.ANY);
                    ClipboardContent content = new ClipboardContent();
                    content.putString(circle.getId());
                    db.setContent(content);

                    System.out.print("onDragDetected");

                    event.consume();
                }
            });