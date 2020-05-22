int sum = 0;
for(int i = 0; i < total; i++) { 
    for(int j = i + 1; j < total; j++) {
        for(int k = j; k < total; k++) {
            sum++;    
        }
    }
}