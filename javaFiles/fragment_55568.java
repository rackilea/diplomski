public class MyServletRequestDataBinder extends ServletRequestDataBinder {

private MessageCodesResolver messageCodesResolver = new MyMessageCodesResolver();

@Override
public void initBeanPropertyAccess() {
   super.initBeanPropertyAccess();
   BindingResult bindingResult = super.getBindingResult();
   if(bindingResult instanceof AbstractBindingResult) {
       ((AbstractBindingResult)bindingResult).setMessageCodesResolver(messageCodesResolver);
   }
}

@Override
public void initDirectFieldAccess() {
  super.initDirectFieldAccess();
  BindingResult bindingResult = super.getBindingResult();
  if(bindingResult instanceof AbstractBindingResult) {
     ((AbstractBindingResult)bindingResult).setMessageCodesResolver(messageCodesResolver);
    }
 }
}