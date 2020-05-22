BufferedReader br = null;
try {
        br = new BufferedReader(new FileReader("/users/Moath Ibrahem/Desktop/Questions.txt"));
        String str = br.readLine();
        if(!str.equals("")) {
            System.out.print(str);
        }
        /* Repeat */
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }