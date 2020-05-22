let str = "Dataset1:[ 10,22,33,44,55,66,7 ],Dataset2:[ 20,12,43,24,55,26,47 ],Dataset3:[ 30,12,53,64,5,16,77 ],Dataset4:[40,12,63,64,5,6,44 ]";
let result = str.split(',Dataset');
result[0] = result[0].split('Dataset')[1];

let obj = result.reduce( (prev, curr) => {
    let ar = curr.split(':');
    prev['Dataset' + ar[0]] = JSON.parse(ar[1]);
    return prev;
}, {} );

console.log(obj);