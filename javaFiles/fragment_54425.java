byte data = ...;

// Set it (to 1)
data = data | (1 << pos);

// Unset it (to 0)
data = data & ~(1 << pos);