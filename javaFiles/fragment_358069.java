String input = "1_2_3";
long areaBits = 0;
for (String numTxt : input.split("_")) {
    areaBits |= 1L << Integer.parseInt(numTxt);
}
System.out.printf("\"%s\"  ->  %d (decimal)  =  %<x (hex)  =  %s (binary)%n",
                  input, areaBits, Long.toBinaryString(areaBits));