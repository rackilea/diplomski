class UserAddingHandlerInterceptor extends HandlerInterceptorAdapter {

    // Autowire dependencies...

    private static final String ATTRIBUTE = "user";

    @Override
    public void postHandle(HttpServletRequest request, 
                           HttpServletResponse response, 
                           Object handler, 
                           ModelAndView modelAndView) throws Exception {

        if (modelAndView != null && !modelAndView.getModelMap().hasAttribute(ATTRIBUTE) {
            modelAndView.addObject(ATTRIBUTE, userDao.getuser(principal.getUsername()));
        }
    }
}