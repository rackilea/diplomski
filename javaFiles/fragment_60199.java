URL url = getClass().getResource("/files/big.txt");
     try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String nameList;
            while ((nameList = in.readLine()) != null) {
                System.out.println(nameList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }