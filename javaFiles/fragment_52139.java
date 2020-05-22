textArea.setCache(false);
ScrollPane sp = (ScrollPane)textArea.getChildrenUnmodifiable().get(0);
sp.setCache(false);
for (Node n : sp.getChildrenUnmodifiable()) {
    n.setCache(false);
}