public void add(int numbers) {
    // Handles out of bounds case
    if (numbers < 0 || numbers > max)
        return;

    count[numbers]++;
}