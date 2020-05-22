class AComplexObject implements IThemable
{
     public bool Selected; // a primitive property we want themeble

     public AnotherComplexObject anotherComplexObject; // implements IThemeable

     public List<IThemable> Children;

     // your object may have other themeable and non-themeable properties.

     public AComplexObject()
     {
         Children = new List<IThemable>();
         UpdateThemableProperties();
     }

     public void UpdateThemableProperties()
     {        
         if (App.CurrentTheme != null)
         {
             // take care of your primitive properties first by practice
             object valueFromTheme = App.CurrentTheme.getPropertyValue("AComplexObject,"Selected");
             Selected = (valueFromTheme != null) ? valueFromTheme : false;
             // false would be the default value if the theme didn't provide it.

             // Do the same as above for all primitive properties you want to
             // participate in the theme.

             // Do for each individual complex property
             if(anotherComplexObject != null)
             {
                anotherComplexObject.UpdateThemeableProperties();
             }

             // Do for each of your lists of complex objects:
             for each (IThemable it in Children)
             {
                  it.UpdateThemeableProperties();
             }
         }
     }
}