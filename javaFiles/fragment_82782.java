private static String SEPARATOR = "#";

    // Add Null pointer check
    private static void readFromFile(String username, String password) {
        BufferedReader bufferedReader = null;
        String finalCred = null;
        try {
            String line = null;
            bufferedReader = new BufferedReader(new FileReader(FILE_NAME));
            username = username.trim();
            password = password.trim();
            while ((line = bufferedReader.readLine()) != null) {
                String split[] = line.split(SEPARATOR);
                if (username.equals(split[0]) && password.equals(split[1])) {
                    finalCred = line;
                }
            }
            String split[] = finalCred.split(SEPARATOR);
            if (username.equals(split[0]) && password.equals(split[1])) {
                Boolean admin = Boolean.parseBoolean(split[2]);
                if (admin) {
                    System.out.println("User is admin");
                } else {
                    System.out.println("Not admin");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void writeInFile(String username, String password, Boolean admin) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME,true));
            admin = (admin == null ? false : true);
            username = username.trim();
            password = password.trim();
            bufferedWriter.write(username + SEPARATOR + password + SEPARATOR + admin + SEPARATOR + Calendar.getInstance().getTimeInMillis()+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }