IOContainer ioResult = process.run();
if (ioResult.getElementAt(0) instanceof ExampleSet) {
    ExampleSet resultSet = (ExampleSet) ioResult.getElementAt(0);

    for (Example example : resultSet) {
        Iterator<Attribute> allAtts = example.getAttributes().allAttributes();
            while (allAtts.hasNext()) {
                Attribute a = allAtts.next();
                if (a.isNumerical()) {
                    double value = example.getValue(a);
                    System.out.print(value + " ");
                } else {
                    String value = example.getValueAsString(a);
                    System.out.print(value + " ");
                }
            }
            System.out.println("\n");
     }
}