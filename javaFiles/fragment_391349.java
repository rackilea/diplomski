public boolean hasCompletedAllRequiredClasses()
{
     for(int i = 0; i < inCompleteClasses.length; i++)
        {
            if(inCompleteClasses[i]!=null)
                return false;
        }
     return true;
}