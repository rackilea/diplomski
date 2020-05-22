int i =set.length
int j = sum
while (i>=0 && j>=0){
  if (take[i][j]){
    print(set[i])
    j = j - set[i]
    i=i-1
  }
  else{
    i=i-1
  }
}