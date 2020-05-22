//Adds the rows together. 
    for (int i=0;i<matrix.length;i++){ 
        total=0; 
        for (int j=0;j<matrix[i].length;j++)    
            total+=matrix[i][j]; 
        nums[total]++;
    }