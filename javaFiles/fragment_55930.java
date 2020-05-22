protected CommerceItem mergeOrdersCopyCommerceItem(Order pSrcOrder, Order pDstOrder, CommerceItem pItem) throws CommerceException {

    NewCommerceItem item = (NewCommerceItem) pItem;
    NewCommerceItem newItem = (NewCommerceItem) super.mergeOrdersCopyCommerceItem(pSrcOrder, pDstOrder, pItem);
        //Now your code to add the changes.
            newItem.setABC(item.getABC());
    return newItem;
    }