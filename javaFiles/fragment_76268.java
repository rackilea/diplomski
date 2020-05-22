// Custom assertion here, when the selected option is defined, only validate which is necessary
// We're using javascript expression language to do the comparison
@AssertValid(when="js:_this.selectedOption == com.company.core.adjustment.ConsumerManagementOption.ADJUST_CARD_VALUE")
private ConsumerAdjustment consumerAdjustment = new ConsumerAdjustment();
@AssertValid(when="js:_this.selectedOption == com.company.core.adjustment.ConsumerManagementOption.COMBINE_CARDS")
private ConsumerCombineAccounts consumerCombineAccounts = new ConsumerCombineAccounts();