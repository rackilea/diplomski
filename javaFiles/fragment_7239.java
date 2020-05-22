private String getWord(int cat) {
    String [] array = null;
    if (cat == CATEGORY_CITY) {
        array = getResources().getStringArray(R.array.cityarray);
    } else if (cat == CATEGORY_ANIMAL) {
        array = getResources().getStringArray(R.array.animalarray);
    } else if (cat == CATEGORY_FRUIT) {
        array = getResources().getStringArray(R.array.fruitarray);
    } else if (cat == CATEGORY_PLANT) {
        array = getResources().getStringArray(R.array.plantarray);
    }

    return array == null ? "ERROR" : array[new Random().nextInt(array.length)];
}