RelativeLayout.LayoutParams _firstRowParams = 
(RelativeLayout.LayoutParams)_firstRow.getLayoutParams();
_firstRowParams.removeRule(EXISIING_RULE)//RelativeLayout.Below or RelativeLayout.Above or any other
_firstRowParams.addRule(RelativeLayout.BELOW, R.id.divider);

RelativeLayout.LayoutParams _dividerParams = 
(RelativeLayout.LayoutParams)_divider.getLayoutParams();
_dividerRowParams.removeRule(EXISIING_RULE)//RelativeLayout.Below or RelativeLayout.Above or any other
_dividerParams.addRule(RelativeLayout.BELOW, R.id.secondRow);