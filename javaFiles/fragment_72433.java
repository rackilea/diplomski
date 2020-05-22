for (int i = 0; i < length; i++) {
        //blank space must be in last position
        if (boardCopy[i] == 0) {
            if (i != length -1) {
                return false;
            }
            continue;   // can be in an else block or omitted
        }
        //out of order if value does not match index + 1 (zero indexed)
        else if (boardCopy[i] != i +1) {
            System.out.println("Out of order: " + boardCopy[i] + ", " + (i+1));
            return false;
        }
    }