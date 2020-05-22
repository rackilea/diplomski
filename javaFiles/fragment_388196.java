@Override
     public void onMinusClick(int position) {
            String parNum = mGameItemList.get(position).getText2();
            int intParNm = Integer.valueOf(parNum);

            if (intParNm != 1) {
                intParNm -= 1;
                totalCounter -= 1;
               mGameItemList.get(position).changeText2(Integer.toString(intParNm));
               mGameItemList.get(position).changeText4(Integer.toString(totalCounter));
               adapter.notifyItemChanged(position);
                }

            }