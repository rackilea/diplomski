console.log(countGroups([1, 8, 5, 6, 10, 9, 11, 12]));    //5 - [1], [8, 5, 6], [10, 9], [11], [12]
console.log(countGroups([1, 8, 5, 6, 10, 9, 2, 11, 12])); //4 - [1], [8, 5, 6, 10, 9, 2], [11], [12]
console.log(countGroups([3, 8, 5, 6, 10, 9, 2, 11, 1]));  //1 - [3, 8, 5, 6, 10, 9, 2, 11, 1]
console.log(countGroups([1, 2, 8, 6, 10, 9, 11]));        //5 - [1], [2], [8, 6], [10, 9], [11]
console.log(countGroups([1, 2, 1, 1, 10, 9, 10]));        //4 - [1], [2, 1, 1], [10, 9], [10]

function countGroups(a) {
    if (a.length < 2) return a.length;
    let stack = [0];
    for (let i = 1; i < a.length; i++) {
        if (a[i] >= a[i - 1]) stack.push(i);
        for (let j = i; j > 0 && a[j] < a[j - 1]; j--) {
            swap(a, j, j - 1);
            if (j <= stack[stack.length - 1]) stack.pop();
        }
    }
    return stack.length;
}

function swap(a, i, j) {
   let t = a[i];
   a[i] = a[j];
   a[j] = t;
}