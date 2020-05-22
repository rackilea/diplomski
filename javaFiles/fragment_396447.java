if (categoriesList.isSelectionEmpty()) {
    mp.add(new NoCategorySymbol(x,y));
} else {
    // here we know categoriesList.getSelectedValue() isn't null
    String selectedValue = categoriesList.getSelectedValue());
    if ("Underground".equals(selectedValue)) {
       mp.add(new UndergroundSymbol(x,y));
    } else if ("Train".equals(selectedValue)) {
       mp.add(new TrainSymbol(x, y));
    }
}
mp.validate();
mp.repaint();