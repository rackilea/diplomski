double currentClosest = array[0][0];

        for(int row = 0; row < array.Length; row++){
            if(Math.Abs(v - array[row][0]) < Math.Abs(v - currentClosest)){
                new_v = array[row][1];
                currentClosest = array[row][0];
            }
        }