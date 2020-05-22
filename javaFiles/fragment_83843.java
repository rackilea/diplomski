int length = s.length();
    int count  = 0;
    int z = 0;
    while (z < length) {
        int y = s.indexOf(x, z);
        if(y == -1){
            break;
        }
        z = (y == z) ? z + 1 : y + 1;

        if (s.charAt(y) == x) {
            count = count + 1;
        }
    }
    System.out.print(count);