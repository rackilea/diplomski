int numUser = Integer.parseInt(inputUser);
int index = -1;
for (int i = 0; i < sum.length; ++i) {
    if (sum[i] == numUser) {
        index = i;
        break;
    }
}
if (index < 0) {
    System.out.println("The number is not in the array");
} else {
    System.out.println("The number is in the array: " + index);
}