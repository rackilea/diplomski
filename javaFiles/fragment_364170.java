if (input.down && yToMove == 0)  
    yToMove = -32;
if (input.up && yToMove == 0)    
    yToMove = 32;
if (input.left && xToMove == 0) 
    xToMove = -32;
if (input.right && xToMove == 0) 
    xToMove = 32;