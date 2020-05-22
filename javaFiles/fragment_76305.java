ItemStack input = i.getItem(2); // Get the ItemStack at slot two

if (input == null) { // If there is nothing in that slot
    player.sendMessage("There are no items to trade up!");
} else if (input.equals(chests)) { // If it contains the sword
    // Execute the trade
}
// Optionally send message if it is the wrong item