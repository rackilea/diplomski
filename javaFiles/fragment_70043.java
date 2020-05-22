int i = 2;

// This part is from ++i
i = i + 1;
int left = i; // 3

// This part is from i++
int right = i; // 3
i = i + 1;

int j = left + right; // 3 + 3 = 6