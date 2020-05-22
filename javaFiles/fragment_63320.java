0. If number =< 0, return.

1. Modulo by 26. Convert 0-25 to 'A'-'Z'. //This is our units column.

Loop {

    2. Divide the number by 26 (integer division rounding down).

    3. If number =< 0, return.

    4. Modulo by 26. Convert 0-25 to 'Z','A'-'Y'. //This is our next column (prepend to string output).

}