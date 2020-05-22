public ShoppingBasketOutput getBasketTotalPrice(List<ShoppingItemDTO> itemsDTO) {
    return itemsDTO.stream().reduce(
        new ShoppingBasketOutput(),
        (output, item) -> {
            ItemEnum itemEnum = ItemEnum.getItem(item.getName()).orElseThrow(ProductNotFoundException::new);
            output.setSubTotal(output.getSubTotal() + itemEnum.getPrice() * item.getQuantity());
            output.setTotalDiscount(output.getTotalDiscount() + getItemTotalDiscount(itemEnum, item.getQuantity()));
            return output;
        },
        (output1, output2) -> {
            output1.setSubTotal(output1.getSubTotal() + output2.getSubTotal());
            output1.setTotalDiscount(output1.getTotalDiscount() + output2.getTotalDiscount());
            return output1;
        }
    );
}