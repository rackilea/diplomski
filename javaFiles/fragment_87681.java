if (numbers.length == 0) {
    throw new NoSuchElementException("no numbers, so 'most frequent' makes no sense");
}

int[] counts = new int[10];

for (int num : numbers) {
    if (num == 0) {
        ++counts[0];
    } else {
        num = Math.abs(num);
        while (num > 0) {
            int digit = num % 10;
            num /= 10;
            ++counts[digit];
        }
    }
}

return IntStream.range(0, counts.length)
    .reduce((i, j) -> counts[i] < counts[j] ? j : i)
    .getAsInt();