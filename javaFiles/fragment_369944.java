ItemStack box =
new ItemBuilder(Material.ENDER_CHEST)
.setName("Mystery Box")
.setLore("Rightclick to open this box");
.toItemStack();

if (boxes > 0)
{
  for (int i = 0; i < boxes; i++)
  {
    boxInventory.getSlot(i).setStack(Copier.copy(box));
  }
}