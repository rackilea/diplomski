function member(arr, num, index) -> bool :
    if index does not exceed array
        return arr[index] equals num or member(arr, num, index+1)
    else 
        return false

arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20}
for i from 1 to 20
    print i, member(arr, i, 0)