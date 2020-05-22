int MAX = 5;

        ArrayList<Double> myList = new ArrayList<Double>(5);

        try {
            for (int i = 0; i < 8; i++)// to throw IndexOutOfBoundsException
            {
                if(myList.size()>MAX)
                    throw new IndexOutOfBoundsException("My message");
                myList.add(0.0);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception : "+e.getMessage());

        }