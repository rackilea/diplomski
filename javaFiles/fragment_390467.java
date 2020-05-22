// Get the current character from the array:
char character = chars[currentIndex];

// Characters are just numbers. Check out e.g. an "ASCII table".
// So, let's start treating them like numbers and take 'a' from that.
int indexInCounts = character - 'a';

// Increase the count for that letter:
counts[indexInCounts] = counts[indexInCounts] + 1;