if (otherItem.myItemName.equals(this.myItemName)
        && otherItem.myItemPrice.equals(this.myItemPrice)) { 
        if (otherItem.myItemBulkQuantity != 0 
                        && !otherItem.myItemBulkPrice.equals(BigDecimal.ZERO)) {
            result = otherItem.myItemBulkPrice.equals(this.myItemBulkPrice)
                && otherItem.myItemBulkQuantity == this.myItemBulkQuantity;                   
        } 
}