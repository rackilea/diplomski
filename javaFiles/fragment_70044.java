int i = 2;

// This part is from i++
int left = i; // 2
i = i + 1;

// This part is from ++i
i = i + 1;
int right = i; // 4


int j = left + right; // 2 + 4 = 6