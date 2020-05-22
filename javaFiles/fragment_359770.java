ArrayList<Integer> toCampus = new ArrayList<>(
                Arrays.asList(623, 1234, 1734, 2100)
);

Scanner scnr = new Scanner(System.in);
System.out.print("What time do you have to be in class?: ");
int classTime = scnr.nextInt();

int index = Collections.binarySearch(toCampus, classTime);
System.out.println(index);
if (index < 0) {
    index = Math.abs(index) - 1;
}

if (index > 0 && index <= toCampus.size()) {
    int time = toCampus.get(index - 1);
    String value = String.format("%04d", time);
    LocalTime lt = LocalTime.parse(value, DateTimeFormatter.ofPattern("HHmm"));
    System.out.println(DateTimeFormatter.ofPattern("hh:mm a").format(lt));
} else {
    System.out.println("Go back to bed");
}