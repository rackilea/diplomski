int[] values = new int[args.length];
for (int i = 0; i < args.length; i++) {
    values[i] = Integer.parseInt(args[i]);
}
int temp = 0;
for (int i = 0; i < values.length - 1; i++) {
    for (int j = i + 1; j < values.length; j++) {
        if (values[i] > values[j]) {
            temp = values[j];
            values[j] = values[i];
            values[i] = temp;
        }
    }
}
System.out.println(Arrays.toString(values));