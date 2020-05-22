for(String name : studentMap.keySet())
    {
        ArrayList<Integer> scoreList=studentMap.get(name);

        System.out.println("Name : "+name+"     Jan Score: "+scoreList.get(0)+"     Feb Score : "+scoreList.get(1));
    }