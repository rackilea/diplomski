try {
    View my_view = (View)(new Activity());
}
catch(ClassCastException e)
{
    // This will always happen. Activity isn't a parent or subclass of View.
}