function impureFunc(value){
  return Math.random() * value;
}

function pureFunc(value){
  return value * value;
}

var impureOutput = [];
for(var i = 0; i < 5; i++){
   impureOutput.push(impureFunc(5));
}

var pureOutput = [];
for(var i = 0; i < 5; i++){
   pureOutput.push(pureFunc(5));
}

console.log("Impure result: " + impureOutput); // result is inconsistent however input is same. 

console.log("Pure result: " + pureOutput); // result is consistent with same input