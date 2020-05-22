public String getPath(String defaultPath)
{
    StringCover stringCover = new StringCover();
    try{
        SwingUtilities.invokeAndWait( () -> {
             // Ask here the user for the path
             stringCover.setString(new PathSelector(defaultPath).getPath());
        }
    } catch (InvocationTargetException e) {
        stringCover.setString("");
    } catch (InterruptedException e) {
        stringCover.setString("");
    }
    return stringCover.getString();
}