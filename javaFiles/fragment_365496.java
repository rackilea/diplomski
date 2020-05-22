public static void onYearSelect(View view) {

    Spinner yearSelector;
    yearSelector = (Spinner) view.findViewById(R.id.year_submit);
    yearName = yearSelector.getSelectedItem().toString();

}