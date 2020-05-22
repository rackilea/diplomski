int myArr[] = {1, 2, 3, 4};
int count = 0 ;
for (int i: myArr){
     myArr[count] = i+1;
     myWindow.writeOutLine(myArr[count]);
     count++;
}