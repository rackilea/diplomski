for(int i=0;i<boxPool.size();i++) 
    {   
        //         V  
        for(int j=i+1;j<boxPool.size();j++) // <-- this line has changed! 
        {
            if(boxPool.get(i) != boxPool.get(j) && checkCollision(boxPool.get(i),   boxPool.get(j)))
            {
                boxPool.get(i).colliding = true;
                boxPool.get(j).colliding = true;
            }
        }
    }