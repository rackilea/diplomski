import com.opensymphony.xwork2.ActionContext;

if( loginSuccess(userInfo) ) {
   ActionContext context = ActionContext.getContext(); 
   initializeDatas(context); // calling thread after userInfo bean validated
   // redirecting to home page
   return HOME_PAGE;
}