rule "Offer for Gold on Festival"
when
    $productObject: Product(type == "gold") && 
    Product(this == $productObject, event == "sale")
then
    $productObject.setDiscount($productObject.getDiscount() + 5);
end