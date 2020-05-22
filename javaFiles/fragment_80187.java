public void doSomethingMethod(ItemStack... arrayOfItemStacks) {
    for (ItemStack itemStack : arrayOfItemStacks) {
        // Do something with itemStack
    }
}

(...)

doSomethingMethod(itemStack1, itemStack2);

ItemStack[] itemStacks = new ItemStack[100];
// Assign 100 ItemStacks to itemStacks
doSomethingMethod(itemStacks);