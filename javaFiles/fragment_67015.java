public boolean isSymStr() {
        for (temp = 0; temp < getLength(); temp++) {
            if (strBuffer.charAt(temp) == strBuffer.charAt(getLength() - (temp + 1))) {
                flag++;
            }
        }
        if (flag == getLength()) {
            return true;
        } else {
            return false;
        }
    }