OptionalDouble optionalAverage = grades.stream()
        .mapToInt(Integer::intValue)
        .average();

if (optionalAverage.isPresent()) {
    double average = optionalAverage.getAsDouble();
    System.out.println(average);
}