private boolean checkItemId(MyOrderResultPOJO myOrderResultPOJO)
{
    for (int i=0;i<myOrderResultList.size();i++) {
        if (myOrderResultList.get(i).getItemId().equals(myOrderResultPOJO.getItemId())) {
            Log.d("myOrderResultList","entering");
            return true;
        }
    }

    return false;    
}