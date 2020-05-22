// Check the input.
    if (number >= 2)
        System.out.println(sum(number));
} 

// Will find the sum if the number is greater than 2.
int sum(int n) {
    return n == 2 ? n - 2 : n % 2 == 0 ? n + sum(n - 2) : sum(n - 1);
}