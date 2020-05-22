@Override
public void itemStateChanged(ItemEvent event) {

    double total = getTotal();
    totPrice.setText(NumberFormat.getCurrencyInstance().format(total));
}

protected double getTotal() {
    double total = 0;
    total = pizzaPrice[pizzaBox.getSelectedIndex()];

    total += extraCheeseBox.isSelected() ? 1 : 0;
    total += pepperoniBox.isSelected() ? 1 : 0;
    total += sausageBox.isSelected() ? 1 : 0;
    total += groundBeefBox.isSelected() ? 1 : 0;
    total += onionBox.isSelected() ? 1 : 0;
    total += mushroomBox.isSelected() ? 1 : 0;
    total += blackOlivesBox.isSelected() ? 1 : 0;
    total += greenPeppersBox.isSelected() ? 1 : 0;
    total += jalepenosBox.isSelected() ? 1 : 0;
    return total;
}