public void saveResultList(MyOrderResultPOJO myOrderResultPOJO) 
{
    if (!checkItemId(myOrderResultPOJO)) {
        myOrderResultList.add(myOrderResultPOJO);
    }

    setMyOrderResultListNew(myOrderResultList);
}