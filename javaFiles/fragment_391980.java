if(hundredModulo == 0){
            return hundreds[hundreadsdivide] +tens[tensdivide] + ones[unit];
    }else if (hundredModulo <20) {
        return hundreds[hundreadsdivide] +"and" + ones[hundredModulo];
    } else {
        //one hundred and tewnty
        return hundreds[hundreadsdivide] +"and" +tens[tensdivide] + ones[unit];
    }