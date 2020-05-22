for (PriceWithCurrency currency : commercialPrices) {
     ProductData purchaseData = new ProductData(purchaseLineItem.getProduct().getProductId(),
               purchaseLineItem.getProduct().getShortDescription(), purchaseLineItem.getQuantity(),
crewSalesRecords, currency.getPrice());
     uncombinedProductDataList.add(purchaseData);
     break;
}