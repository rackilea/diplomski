try {
                //fileStream = new FileOutputStream(filename);
                oos = new ObjectOutputStream(fileStream);
               + List<AllData> nonNullList = new ArrayLis<>();
               + for(AllData aData: valuelist)
               +    if(aData != null) nonNullList.add(aData);
               + oos.writeObject(nonNullList);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }