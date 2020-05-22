public Map<Month, Integer> calculateCumulativeMonthlySpends() {

    //Get the min startDate of all the  modules
    LocalDate localDateStart = modules.stream()
            .flatMap(modules -> module.getWorkingDays().stream())
            .min(LocalDate::compareTo).get();
    //Get the max endDate of all the modules
    LocalDate localDateEnd = modules.stream()
            .flatMap(module -> module.getWorkingDays().stream())
            .max(LocalDate::compareTo).get();

    //Iterate from the start date to the end date, calculate the daily cost for all the module
    //and sum the cost of all the days for the all modules
    //Then create a map with moth as a key and the cost of all the modules for each month
    //Finally sort the map by key

    return Stream.iterate(localDateStart, d -> d.plusDays(1))
            .limit(ChronoUnit.DAYS.between(localDateStart, localDateEnd) + 1)
            .collect(Collectors.toMap(LocalDate::getMonth, day -> dailyCost(day, modules), Integer::sum))
            .entrySet()
            .stream()
            .sorted(Map.Entry.comparingByKey())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
}

/**
 * Calculate the daily cost for all the modules
 * Check if the modules's working days contain the attribute day
 * If yes sum(),  add the daily cost of this module to the other modules' daily cost
 *
 * @param day
 * @param modules
 * @return
 */
private Integer dailyCost(LocalDate day, Set<Module> modules) {

    return modules.stream()
            .filter(module -> module.getWorkingDays().contains(day))
            .flatMap(p -> p.getCommittedHoursPerDay().entrySet().stream())
            .mapToInt(e -> e.getKey().getHourlyWage() * e.getValue())
            .sum();
}