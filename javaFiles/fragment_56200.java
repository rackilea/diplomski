const regex = /(.*my).*(is.*)/g;
const regex2 = /.*my(.*)is.*/g;
const str = `Hello my name is Skypit`;
const result = str.replace(regex, `$1$2`);
const result2 = str.replace(regex2, `$1`);
console.log('Output 1 : ',result);
console.log('Output 2 : ',result2);