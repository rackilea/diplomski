for(Class innerClass: AbsSavedState.class.getDeclaredClasses())
{
    if(innerClass.getSuperclass().equals(AbsSavedState.class))
        {
            System.out.println("Sub inner class: " + innerClass.getName());
        }
    }
}