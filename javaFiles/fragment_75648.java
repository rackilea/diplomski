// using round because an equivalent int/long may be represented by a near binary fraction
// as floating point calculations aren't exact
// e.g. 3.999999.. for 4
long longRoot = Math.round(root1); 
if(a*longRoot*longRoot +  b*longRoot + c==0){
    //its valid int root
}else{
    //ignore it
}