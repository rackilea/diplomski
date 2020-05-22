// i = i++
temp = i;
i = i + 1;
i = temp; // so i equals the initial value of i (not the incremented value)

// i = ++i;
i = i + 1;
temp = i;
i = temp; // which is i + 1

// i = i++
temp = i;
i = i + 1;
i = temp; // so i equals the previous value of i (not i + 1)