int counter = 0;                                    //indices for long array
for(int i =0; i<nums.length; i++){                      //populate
    for(int j = 0; j<nums[i].length; j++){
        System.out.println(temp[counter]);
        temp[counter++] = (int)nums[i][j];
    }
}