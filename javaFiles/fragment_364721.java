public void addCurrentList(String filePath) throws Exception

            try {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filePath));



                os.writeObject(list);
                os.close();
            }
            catch (Exception e) {

                System.out.println(e.getMessage());


            }
        }

public void record(String filePath) {

        try {

            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
            ArrayList<Item> list2 = (ArrayList<Item>) in.readObject();
            System.out.println(list2);
            list = list2;

            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }