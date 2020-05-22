Scanner sc = new Scanner(System.in);
        System.out.println("Please input your zodiac sign:");
        String sign = sc.nextLine();
        String file = ".txt file";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            String sign2 = "";
            String content = "";
            String nl = System.getProperty("line.separator");
            //I assummed that your text not end with [end] for each sign zodiac.
            while ((line = br.readLine()) != null) {
                String l = line.trim().toLowerCase();
                //Check if line is equal than some zodiac sign.
                String sign3 = "";
                if (l.equals("aries")) {
                    sign3 = "aries";
                } else if (l.equals("tauro")) {
                    sign3 = "tauro";
                } //complete here all zodiac sing with else if.

                //Check if sign is equal than sign enter by user and data content for this sign still not ready. 
                if (sign2.length() == 0 && sign3.length() != 0 && sign.toLowerCase().equals(sign3)) {
                    sign2 = sign3;
                } else {
                    //Check if we need concatenate data for this sign.
                    if (sign2.length() > 0 && sign3.length() == 0) {
                        content += line + nl;
                    } else {
                        //If this line is equal other sign and content data we finalized and break.
                        if (sign2.length() > 0 && sign3.length() != 0) {
                            break;
                        }
                    }
                }

            }
            br.close();

            System.out.println(content);
        } catch (Exception ex) {
            System.out.println("Cannot find" + file);
        }