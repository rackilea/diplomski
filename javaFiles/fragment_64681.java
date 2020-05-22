int sqr = (int)Math.sqrt(x);
    if (2 <= sqr) {
        if (x % 2 == 0)        
            return false;
    }
    for (int i = 3; i <= sqr; i += 2) {
        if (x % i == 0)        
            return false;
    }
    return true;