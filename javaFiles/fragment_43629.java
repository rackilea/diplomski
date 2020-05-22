for (int col = 0; col < array[row].length; col++) {
// assing current location to temp variable
                temp = temp + array[row][col];
            }

            if (temp > highest) {
                highest = temp;
                result = col;
            }