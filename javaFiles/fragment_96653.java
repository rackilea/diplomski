public int howManyBetweenTheseYears(int startYear, int endYear) {
    int totalYear = 0;
    for (Lamborghini year : inventory) {
        int modelYear = year.getModelYear();
        if ((modelYear >= startYear) && (modelYear <= endYear)) {
            totalYear++;
            System.out.printf("modelYear: %d, total: %d%n", modelYear, 
                    totalYear);
        }
    }
    return totalYear;
}