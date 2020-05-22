public static void main(String[] args) throws Exception {
    TempStruct ts =
        (TempStruct)instantiate(
            Arrays.asList("373.15", "Kelvin"),
            TempStruct.class.getName());

    System.out.println(
        ts.getClass().getSimpleName() + " " +
        ts.tempValue + " " +
        ts.unitOfMeasurement);
}