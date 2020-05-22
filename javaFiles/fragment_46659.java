br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {

            if (line.startsWith("\"user")) {

                if (!firstElement)
                    System.out.print("]\n");

                System.out.print("users [");
                firstElement = true;

            }
            // use comma as separato
            String[] country = line.split(cvsSplitBy);

            for (int i = 0; i < country.length; i++) {

                if (country[i].trim().length() != 0) {
                    if (country[i].endsWith("=\"")) {
                        country[i] = country[i].substring(0,
                                country[i].length() - 2);
                    }
                    if (firstElement) {
                        System.out.print(country[i].substring(1));

                        firstElement = false;
                    }

                    else {
                        System.out.print(", " + country[i]);
                    }
                }
            }

        }
        System.out.print("]\n");