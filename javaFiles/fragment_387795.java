public enum Constraint
{
    CHECK_NONE
    {
        @Override void apply(UserElement element)
        {
            element.setChecked(false);
        }
    },
    CHECK_ALL
    {
        @Override void apply(UserElement element)
        {
            element.setChecked(true);
        }
    };

    public abstract void apply(UserElement element);
}