public class DecryptPassword extends Task
{
    @Override
    public void execute()
    {
        ...
        PropertyHelper.getPropertyHelper(getProject()).setProperty(null, passwordProperty, getDecryptedPassword(),
                            false);
        ...                 
    }
}