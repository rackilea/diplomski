public class RequestInterceptor extends HandlerInterceptorAdapter {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                    throws Exception {

                final String startTime = DateUtils.getUTCDate();

                request.setAttribute("startTime", startTime);


                **try {
                    Locale.LanguageRange.parse(request.getHeader("Accept-Language"));
                } catch (IllegalArgumentException e) {
                    throw new InvalidAcceptLanguageException();
                }**

                return true;

            }
        }