public class AppPortalViewResolver implements ViewResolver {

 private ViewResolver viewResolver;

 public void setViewResolver(ViewResolver viewResolver) {
  this.viewResolver = viewResolver;
 }


 @Override
 public View resolveViewName(String viewName, Locale locale) throws Exception {
      /* do your logic to change the view name  */
      viewName = "ur_folder_structure";
     return viewResolver.resolveViewName(viewName, locale);      
}