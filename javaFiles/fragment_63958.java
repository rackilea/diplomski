public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        File file = new File("text.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                String[] str = text.split(" ");
                for (int i = 0; i<str.length; i++) {
                    if(str[i].trim().length() > 0) {
                        list.add(Double.parseDouble(str[i]));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.print(e);
            }
        }

//print out the list
        System.out.println(list);
    }