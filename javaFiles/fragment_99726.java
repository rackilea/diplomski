LinkedList<LinkedList<Map.Entry<Double,Double>>> linkedLists = new LinkedList<>();

test.entrySet().stream().forEach(e -> {
    if (linkedLists.isEmpty() || 
        ! linkedLists.getLast().getLast().getValue().equals(e.getValue())) {
        linkedLists.add(new LinkedList<>());
    }
    linkedLists.getLast().add(e);
});

System.out.println(linkedLists);