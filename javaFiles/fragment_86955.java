/*
*   Microsoft's decompression algorithm - php version
*   returns an array of coordinates (pairs of doubles)
*/
function tryParseEncodedValue($value) {

    $safeCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-";
    $list = array();
    (int)$index = 0;
    (int)$xsum = 0;
    (int)$ysum = 0;

    while ($index < strlen($value))        // While we have more data,
    {
        $n = 0;                             // initialize the accumulator
        $k = 0;                              // initialize the count of bits

        while (true)
        {
            if ($index >= strlen($value)) // If we ran out of data mid-number
            {
                var_error_log('failed: inxed >= strlen($value)');
                return false;             // indicate failure.
            }
            $b = strpos($safeCharacters, $value[$index++]);

            if ($b === false) {           // If the character wasn't on the valid list,
                var_error_log('failed: character not in valid list');
                return false;             // indicate failure.
            }

            // mask off the top bit and append the rest to the accumulator
            // n |= ((long)b & 31) << k;
            $bgmp = gmp_init($b);                           // Here i'm breaking out this function
            $bitwiseand = gmp_and($bgmp, 31);               // on multiple lines because there's 
            $shifted = gmp_shiftl($bitwiseand, $k);         // so many steps
            $n = gmp_or($n, $shifted);
            $k += 5;
            if (gmp_cmp($bgmp, gmp_init(32)) < 0) break;    // gmp compare: b < 32
        }

        // The resulting number encodes an x, y pair in the following way:
        //
        //  ^ Y
        //  |
        //  14
        //  9 13
        //  5 8 12
        //  2 4 7 11
        //  0 1 3 6 10 ---> X

        // determine which diagonal it's on
        //$diagonal = (int)((sqrt(8 * $n + 5) - 1) / 2);
        $diagonal = gmp_intval(gmp_div_q(gmp_sub(gmp_sqrt(gmp_add(gmp_mul($n, 8), 5)), 1), 2));

        // subtract the total number of points from lower diagonals
        // n -= diagonal * (diagonal + 1L) / 2;
        $n = gmp_sub($n, gmp_div_q(gmp_mul($diagonal, gmp_add($diagonal, 1)), 2));

        // get the X and Y from what's left over
        (int)$ny = gmp_intval($n);
        (int)$nx = $diagonal - $ny;

        // undo the sign encoding
        $nx = ($nx >> 1)^ (-($nx & 1));
        $ny = ($ny >> 1)^ (-($ny & 1));

        // undo the delta encoding
        $xsum += $nx;
        $ysum += $ny;

        // position the decimal point
        $coordinate = array($ysum * 0.00001, $xsum * 0.00001);
        array_push($list, $coordinate);
    }

    return $list;
}

// shift left, $x number to shift, $n shift n times. 
function gmp_shiftl($x,$n) { 
    return(gmp_mul($x,gmp_pow(2,$n)));
}