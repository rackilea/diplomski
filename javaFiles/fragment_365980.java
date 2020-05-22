int numUser = Integer.parseInt(inputUser);
int index = Arrays.asList(sum).indexOf(numUser);
if (index < 0) {
    System.out.println("The number is not in the array");
} else {
    System.out.println("The number is in the array: " + index);
}