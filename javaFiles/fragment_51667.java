try {
            ArrayList<Integer> ar=new ArrayList<Integer>();
            Scanner s = new Scanner(System.in);
            System.out.println("ENTER ANY CHARACTER AND PRESS ENTER TO EXIT!!");
            while(s.hasNextInt())
            {
                ar.add(s.nextInt());
            }

            for(int i:ar)
            {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }