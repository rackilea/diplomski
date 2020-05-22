ItemStack hand = player.getItemInHand();
int amount = hand.getAmount();
if (amount > 1) {
    hand.setAmount(amount - 1);
    player.setItemInHand(hand);
} else {
    player.setItemInHand(new ItemStack(Material.AIR));
}