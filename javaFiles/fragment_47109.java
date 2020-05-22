for i = 1 to k
    for z = 0 to sum:
        for j = z-x_i to 0:
            if(T[j][i-1]): 
                T[z][i]=true;
                break;