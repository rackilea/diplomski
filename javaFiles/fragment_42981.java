x= 4023233417;
console.log(x.toString(2))
y = 2562383102 ;
console.log(y.toString(2));

result = x & y;

console.log(result.toString(2)); //-1110111011101110111011101111000

x = x | 0; //-271733879
y = y | 0; //-1732584194
console.log("32 bit x: " + x);
console.log("32 bit y: " + y);
result = x & y;

console.log(result.toString(2)); //-1110111011101110111011101111000