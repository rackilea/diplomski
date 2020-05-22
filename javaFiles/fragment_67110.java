int max = num[0]; 
for(int c = 1; c < num.length; c++) { 
    if(max < num[c]) {
        max = num[c];
    }
}