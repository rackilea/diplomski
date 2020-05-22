while(left < right)
     {
        if(str.charAt(left) != str.charAt(right))
        {
            return false;
        }
        left ++;
        right --;
    }