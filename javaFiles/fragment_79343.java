public int extractMax()
        {
            maxInsert = Queue[0];
            int maxIndex = 0;
            for (int i = 1; i < size; i++)//get the location of the max element
            {
                if(maxInsert < Queue[i])
                {
                    maxInsert = Queue[i];
                    maxIndex = i;
                }
            }
            int[] temp = new int[Queue.length - 1];
            for(int j = 0; j < maxIndex; j++){ //adding elements up until the max
                temp[j] = Queue[j];
            }
            for(int k = maxIndex; k < temp.length; k++){ //adding elements after the max
                temp[k] = Queue[k+1];
            }   
            Queue = temp; //queue is now this new array we've just made
            return maxInsert;
        }