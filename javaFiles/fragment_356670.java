const regex = /(\d{4}-\d{2}-\d{2})[A-Z]+(\d{2}:\d{2}:\d{2}).([0-9+-:]+)/gm;
const str = `2013-08-11T17:22:04.51+01:00`;
const subst = `\nGroup 1: $1\nGroup 2: $2\nGroup 3: $3\n`;

// The substituted value will be contained in the result variable
const result = str.replace(regex, subst);

console.log('Substitution result: ', result);