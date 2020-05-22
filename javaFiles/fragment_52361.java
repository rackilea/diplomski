Object elementRemoved = null;
for(int i=0;i<arrays.length;i++){
    if(!deleteItem[i]){
        newArr[index++] = arrays[i];
    }
    else {
        elementRemoved = arrays[i];
    }
}
arrays = newArr;
return elementRemoved;