public serveItems(Food[] items)
{
    for(Food aFood : items){
        Class<?> foodClass = aFood.getClass(); // Get the food's class
        Method serve = WaiterUtility.class.getMethod("serve", foodClass); // Get the method by name and argument types

        try {
          serve.invoke(this, aFood);
        } catch (IllegalArgumentException e) { // Should never occur, we're matching it up.
        } catch (IllegalAccessException e) { // Shouldn't occur, we're in the same class.
        } catch (InvocationTargetException e) {
            // Handle errors possibly thrown by the serve method.
        }
}