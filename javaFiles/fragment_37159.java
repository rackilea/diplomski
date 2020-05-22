if(H[i] <= lowest){
    while(stack.size() > 0){
        stack.pop();   
    }
    stack.push(H[i]);                
    if (H[i]!=lowest)
    {
        lowest = H[i];
        count++;
    }
}