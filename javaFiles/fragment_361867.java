bit_x_coordinate = Integer.toBinaryString(x_coordinate);
    if(bit_x_coordinate.length() < 32){

    int number_of_bits = bit_x_coordinate.length();

        for(int i = 0; i < (32-number_of_bits); i++){

        bit_x_coordinate = "0" + bit_x_coordinate;
    }
    }