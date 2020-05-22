public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.println("Power: ");
    int power = Integer.parseInt(console.nextLine());
    ArrayList<Integer> weight = new ArrayList<>();
    int averageWagon = 0;
    int sum = 0;

    while (console.hasNextInt()) {
        weight.add(console.nextInt());

    }

    for (int i = 0; i < weight.size(); i++) {
        sum += weight.get(i);
    }

    if (sum > power) {
        averageWagon = sum / weight.size();
        //Here I want to find the closest value to averageWagon
        int closest = findClosestNumber(averageWagon, weight);
        System.out.println("Closest number to average: "+ closest);

    }
    System.out.println(averageWagon);

    System.out.println(weight);
    System.out.println(power);
    System.out.println(sum);

}

static int findClosestNumber(int num, List<Integer> numbers) {
    int closest = numbers.get(0);

    for (int i : numbers) {
        if (Math.abs(num - i) < Math.abs(num - closest)) {
            closest = i;
        }
    }
    return closest;
}