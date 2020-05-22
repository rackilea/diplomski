if (start%3 == 0 && start%5 == 0) {
    array[i] = "FizzBuzz";
}
else if (start%3 == 0 || start%5 == 0) {
    if (start%3 == 0) array[i] = "Fizz";
    if (start%5 == 0) array[i] = "Buzz";
}
else {
    array[i] = String.valueOf(start);
}