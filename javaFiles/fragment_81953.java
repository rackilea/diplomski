public void printItems(SabTabObj item){
   if(item.length()>0)
    {
        for (int j = 0; j < item.length(); j++) {
            SagTab sabTab = item.getElement(j);

            System.out.println(ToStringEntities.toString(sabTab));
        }
    }
}