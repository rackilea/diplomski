for(int i = 0; i < 256; i++){

            String result = "";

            for(int j=128; j > 0; j >>= 1){

                if((j & i) != 0)
                    result += "1";
                else
                    result += "0";

            }
            // now do whatever you want with the String result
}