// Zero if valid, non-zero otherwise
int n = (int) Math.floor((value - 1) / 31.0);

// Convert any non-zero value to -1 (0xFFFFFFFF) without any boolean logic.
n |= n << 1;  n |= n >> 1;    
n |= n << 2;  n |= n >> 2;
n |= n << 4;  n |= n >> 4;
n |= n << 8;  n |= n >> 8;
n |= n << 16; n |= n >> 16;

// Value is either -1 or 0. Switch -1 to +1.
n = -n;

// Use array indexing to simulate a conditional.
String[] results = {"valid", "invalid"};
System.out.println(results[n]);