"use strict";

var isPrime = function(n){
    if (n < 2) {return false};
    if (n === 2) {return true};
    if (n === 3) {return true};
    if (n % 2 === 0) {return false};
    if (n % 3 === 0) {return false};
    var sqrtOfN = Math.sqrt(n);
    for (var i = 5; i <= sqrtOfN; i += 6){
        if (n % i === 0) {return false}
        if (n % (i + 2) === 0) {return false}
    }
    return true;
};

var countPrime = function(S, E){
    var count = 0;
    for (let i = S; i < E;i++){
        if ( isPrime(i) ) { ++count; }
    }
    return count;
};

if( process.argv.length != 4) {
    console.log('Usage: nodejs count_prime.js <range_start> <range_length>');
    process.exit();
}

var S = parseInt(process.argv[2]);
var N = parseInt(process.argv[3]);
var E = S+N;
var P = countPrime(S, E);
console.log('The range [', S, ',', E, ') contains', P, 'primes');