try {
    StringToWordVector filter = new StringToWordVector();
    filter.setInputFormat(htmlInst);
    Instances dataFiltered = Filter.useFilter(htmlInst, filter);
} catch (Exception e) {
    System.err.println("Exception caught during formatting: " + e.getMessage());
    return;
}