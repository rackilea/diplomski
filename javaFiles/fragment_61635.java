list.get(0).getData().get(0).setPieValue(42);
for (PieChart p : list) {
    for (PieChart.Data data : p.getData()) {
        System.out.println(data);
    }
}