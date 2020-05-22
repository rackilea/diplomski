if (s>= 0 && s < data.length) {
            String decodeinput = data[s].trim();

            StringBuilder decodeoutput = new StringBuilder();

            for (int i = 2; i < decodeinput.length() - 1; i += 4) {
                // Extract the hex values in pairs
                String temp = decodeinput.substring(i, (i + 2));
                // convert hex to decimal equivalent and then convert it to character
                decodeoutput.append((char) Integer.parseInt(temp, 16));
            }
            System.out.println("ASCII equivalent : " + decodeoutput.toString());
     }