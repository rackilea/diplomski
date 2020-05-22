const repeat = 1000000;
const start = Date.now();

for (var i = repeat; i >= 0; i--) {
 const string = '2013-08-11T17:22:04.51+01:00';
 const regex = /(\d{4}-\d{2}-\d{2})[A-Z]+(\d{2}:\d{2}:\d{2}).([0-9+-:]+)/gm;
 var match = string.replace(regex, "\nGroup #1: $1 \n Group #2: $2 \n Group #3: $3 \n");
}

const end = Date.now() - start;
console.log("YAAAY! \"" + match + "\" is a match  ");
console.log(end / 1000 + " is the runtime of " + repeat + " times benchmark test.  ");