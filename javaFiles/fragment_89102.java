public static void main(String[] args) throws Exception {
        try (OutputStream os = new FileOutputStream(FILE); BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8))){         
            os.write(239);
            os.write(187);
            os.write(191);

            for (int i = 0; i < COUNT; i++) {               
                writer.write(Integer.toString(i));
                writer.newLine();               
            }          
        } catch (IOException e) {                       
            e.printStackTrace();
        }

        System.out.println(checkLineCount(COUNT, new File(FILE)));
    }