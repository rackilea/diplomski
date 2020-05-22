$ gcc count_primes.c -std=c99 -O3 -lm -o count_primes_long
$ sed 's/long/int/g; s/%li/%i/g' count_primes.c > count_primes_int.c
$ gcc count_primes_int.c -std=c99 -O3 -lm -o count_primes_int

# Count primes <10M using C code with (64-bit) long type
$ time ./count_primes_long 0 10000000
The range [0, 10000000) contains 664579 primes

real    0m4.394s
user    0m4.392s
sys 0m0.000s

# Count primes <10M using C code with (32-bit) int type
$ time ./count_primes_int 0 10000000
The range [0, 10000000) contains 664579 primes

real    0m1.386s
user    0m1.384s
sys 0m0.000s

# Count primes <10M using node.js/V8 which transparently does the
# job utilizing 32-bit types
$ time nodejs ./count_primes.js 0 10000000
The range [ 0 , 10000000 ) contains 664579 primes

real    0m1.828s
user    0m1.820s
sys 0m0.004s