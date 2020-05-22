output = -1;
for (i = 0; i < list.length; i++){
    num = list[i];
    indices[] = \\ get all the indices which the "num" value appears, only include those indices that are greater than "i"
    for (j = 0; j < indices.length; j++){
        flag = true;
        k = i;
        for (l = indices[j]; l >= k; l--, k++){
             if (list[k] != list[l]) {
                 flag = false;
                 break;
             } 
        }
        if (flag){
           length = (indices[j] - i) + 1;
           if (length != 1 && length > output) { // checking of length != 1 will exclude those palindromes of length 2
               output = length;
           }
        }
    }
}
return output;