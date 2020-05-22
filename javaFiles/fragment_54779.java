int max=50;
        List<Integer> indices;
    int randomIndex = 0;
random(){
    int arrIndex = (int)((double)indices.size() * Math.random());
           System.out.println("my random no is:"+arrIndex);
           randomIndex = indices.get(arrIndex);
           indices.remove(arrIndex);
            return randomIndex;
}