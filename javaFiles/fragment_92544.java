function r(array a, int index){
    a[index] = a[index-1]+1
    print a[index]
    r(a, index+1)
}

try{
    array a;
    a.resize(101)
    r(a, 1)
}catch(OutOfBoundsException){
}