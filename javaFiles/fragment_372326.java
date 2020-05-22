mPieChart.setUseCustomInnerValue(true); //to override the inner value
mPieChart.setOnItemFocusChangedListener(new IOnItemFocusChangedListener() {
   @Override
   void onItemFocusChanged(int _Position) {
      //_Position is the position of the pie you inserted, in your case, 0 will be the CARBS, 1 is PROTEIN, 2 is FAT
      if (_Position == 0) {
         mPieChart.setInnerValueString(formatTwoDecimal(CARBS_percent));
      } else if (_Position == 1) {
         mPieChart.setInnerValueString(formatTwoDecimal(PROTEIN_percent));
      } else if (_Position == 2) {
         mPieChart.setInnerValueString(formatTwoDecimal(FAT_percent));
      }
   }
});