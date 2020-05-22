final Table table = new Table(parent, SWT.BORDER);

/* Set up table columns, etc. */

table.pack();

try
{
    /*
     * Locate the method setItemHeight(int). Note that if you do not
     * have access to the method, you must use getDeclaredMethod(). If
     * setItemHeight(int) were public, you could simply call
     * getDeclaredMethod.
     */
    Method setItemHeightMethod =
        table.getClass().getDeclaredMethod("setItemHeight", int.class);

    /*
     * Set the method as accessible. Again, this would not be necessary
     * if setItemHeight(int) were public.
     */
    setItemHeightMethod.setAccessible(true);

    /*
     * Invoke the method. Equivalent to table.setItemHeight(50).
     */
    setItemHeightMethod.invoke(table, 50);
}
catch (Exception e)
{
    /*
     * Reflection failed, it's probably best to swallow the exception and
     * degrade gracefully, as if we never called setItemHeight.  Maybe
     * log the error or print the exception to stderr?
     */
    e.printStackTrace();
}