for(int i = 0; i < 256; i++){

            /* Print out the first 8 bits */
            /* For 16 bits, put this as the first line of the loop:
               for(int j = 32768; j > 0; j >>= 1)
            */
            for(int j=128; j > 0; j >>= 1){

                if((j & i) != 0)
                    System.out.print('1');
                else
                    System.out.print('0');

            }
            System.out.print(' ');
}