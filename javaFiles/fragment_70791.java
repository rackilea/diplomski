//Map containing all enchantments of the ItemStack
//The Map looks like: [KEY,VALUE]
//  [Enchantment.DURABILITY,2],
//  [Enchantment.LOOT_BONUS_BLOCKS,4]
HashMap<Enchantment, Integer> enchantmentMap = YourItemStack.getEnchantments();
//Check if this map contains the wanted Enchantment
if(enchantmentMap.containsKey(Enchantment.LOOT_BONUS_BLOCKS))
//Get VALUE of KEY which is the enchantLevel "4"
Integer enchantmentLevel = enchantmentMap.get(Enchantment.LOOT_BONUS_BLOCKS);