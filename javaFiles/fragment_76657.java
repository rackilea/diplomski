Grid<GridExampleBean> grid = new Grid<GridExampleBean>(GridExampleBean.class);
// you can also use the getColumn method too :  grid.getColumn("number").
grid.addColumn(...)
        .setStyleGenerator((StyleGenerator<GridExampleBean>) item -> {
    if (item.getNumber() < 0) {
        return "red";
    }
    return "notRed";
});