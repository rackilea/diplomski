int numUser = Integer.parseInt(inputUser);
int index = ArrayUtils.indexOf(sum, numUser);
if (index < 0) {
    System.out.println("The number is not in the array");
} else {
    System.out.println("The number is in the array: " + index);
}