const regex = /^[^\s]*$/gm;
const str = `abzzc
I need to validate that a string is not having a whitespace.
abc
pqerweras dfsadfj`;
let m;

while ((m = regex.exec(str)) !== null) {
    if (m.index === regex.lastIndex) {
        regex.lastIndex++;
    }
  console.log(m[0]);

}