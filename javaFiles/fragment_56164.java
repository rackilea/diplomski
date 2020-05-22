/**
     * Determines the input of a IRecipe.
     * This method handles most of the IRecipes, but not all of them.
     * @param Item
     * @return Null if not handled.
     */
    private List<ItemStack> Test(IRecipe Item)
    {
        try
        {
            if (Item instanceof ShapelessRecipes)
            {
                ShapelessRecipes a = (ShapelessRecipes)Item;
                return a.recipeItems;
            }

            if (Item instanceof ShapedRecipes)
            {
                ShapedRecipes a = (ShapedRecipes)Item;
                return Arrays.asList(a.recipeItems);
            }

            if (Item instanceof ShapedOreRecipe)
            {
                ShapedOreRecipe a = (ShapedOreRecipe)Item;

                ItemStack Item2;
                NonNullList<ItemStack> Item1 = NonNullList.create();

                for (Object b: a.getInput())
                {
                    if (b instanceof ItemStack)
                    {
                        Item2 = (ItemStack)b;
                        Item1.add(Item2);
                    }

                    if (b instanceof NonNullList)
                    {
                        NonNullList<ItemStack> NonNull1 = (NonNullList<ItemStack>)b;
                        Item1.addAll(NonNull1);
                    }   

                    return Item1;
                }
            }

            if (Item instanceof ShapelessOreRecipe)
            {
                ShapelessOreRecipe a = (ShapelessOreRecipe)Item;

                ItemStack Item2;
                NonNullList<ItemStack> Item1 = NonNullList.create();

                for (Object b: a.getInput())
                {
                    if (b instanceof ItemStack)
                    {
                        Item2 = (ItemStack)b;
                        Item1.add(Item2);
                    }

                    if (b instanceof NonNullList)
                    {
                        NonNullList<ItemStack> NonNull1 = (NonNullList<ItemStack>)b;
                        Item1.addAll(NonNull1);
                    }   
                }

                return Item1;
            }
        }
        catch (Exception e)
        {
            //Handle the error
        }

        return null;
    }