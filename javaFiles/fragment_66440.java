rule "Offer for Gold on Festival"
when
    $productObject: Product(type == "gold", event == "sale")
then
    $productObject.setDiscount($productObject.getDiscount() + 5);
end