public static void fileProcessing() throws FileNotFoundException {
        String reading = "28 6\n9 5\n2000 2001\n0\n1 23 4";
        Scanner lineByLine = new Scanner(reading); // reads lines by line to
                                                    // count the total lines
        String lines = "";

        while (lineByLine.hasNextLine()) {
            lines = lineByLine.nextLine();
            String[] nums = lines.split(" ");
            StringBuilder sb = new StringBuilder();
            BigInteger sum = new BigInteger("0");
            for(String num : nums){
                sb.append("+").append(num);
                sum = sum.add(new BigInteger(num));
            }
            System.out.println(sb.toString().substring(1)+"="+sum);
        }
    }