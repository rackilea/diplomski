2016-08-02 20:30:35.866  INFO 18404 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring FrameworkServlet 'dispatcherServlet'
2016-08-02 20:30:35.867  INFO 18404 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization started
2016-08-02 20:30:35.883  INFO 18404 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : FrameworkServlet 'dispatcherServlet': initialization completed in 16 ms
2016-08-02 20:30:35.901 DEBUG 18404 --- [nio-8080-exec-1] o.s.s.w.u.matcher.AntPathRequestMatcher  : Checking match of request : '/'; against '/css/**'
2016-08-02 20:30:35.901 DEBUG 18404 --- [nio-8080-exec-1] o.s.s.w.u.matcher.AntPathRequestMatcher  : Checking match of request : '/'; against '/js/**'
2016-08-02 20:30:35.901 DEBUG 18404 --- [nio-8080-exec-1] o.s.s.w.u.matcher.AntPathRequestMatcher  : Checking match of request : '/'; against '/images/**'
2016-08-02 20:30:35.901 DEBUG 18404 --- [nio-8080-exec-1] o.s.s.w.u.matcher.AntPathRequestMatcher  : Checking match of request : '/'; against '/**/favicon.ico'
2016-08-02 20:30:35.901 DEBUG 18404 --- [nio-8080-exec-1] o.s.s.w.u.matcher.AntPathRequestMatcher  : Checking match of request : '/'; against '/error'
2016-08-02 20:30:35.902 DEBUG 18404 --- [nio-8080-exec-1] o.s.security.web.FilterChainProxy        : / at position 1 of 13 in additional filter chain; firing Filter: 'WebAsyncManagerIntegrationFilter'
2016-08-02 20:30:35.903 DEBUG 18404 --- [nio-8080-exec-1] o.s.security.web.FilterChainProxy        : / at position 2 of 13 in additional filter chain; firing Filter: 'SecurityContextPersistenceFilter'
2016-08-02 20:30:35.903 DEBUG 18404 --- [nio-8080-exec-1] w.c.HttpSessionSecurityContextRepository : No HttpSession currently exists
2016-08-02 20:30:35.903 DEBUG 18404 --- [nio-8080-exec-1] w.c.HttpSessionSecurityContextRepository : No SecurityContext was available from the HttpSession: null. A new one will be created.
2016-08-02 20:30:35.906 DEBUG 18404 --- [nio-8080-exec-1] o.s.security.web.FilterChainProxy        : / at position 3 of 13 in additional filter chain; firing Filter: 'HeaderWriterFilter'
2016-08-02 20:30:35.906 DEBUG 18404 --- [nio-8080-exec-1] o.s.s.w.header.writers.HstsHeaderWriter  : Not injecting HSTS header since it did not match the requestMatcher org.springframework.security.web.header.writers.HstsHeaderWriter$SecureRequestMatcher@2583a7b2
2016-08-02 20:30:35.907 DEBUG 18404 --- [nio-8080-exec-1] o.s.security.web.FilterChainProxy        : / at position 4 of 13 in additional filter chain; firing Filter: 'CsrfFilter'
2016-08-02 20:30:35.925 DEBUG 18404 --- [nio-8080-exec-1] o.s.security.web.FilterChainProxy        : / at position 5 of 13 in additional filter chain; firing Filter: ''
2016-08-02 20:30:35.935 DEBUG 18404 --- [nio-8080-exec-1] o.s.security.web.FilterChainProxy        : / at position 6 of 13 in additional filter chain; firing Filter: 'LogoutFilter'
2016-08-02 20:30:35.935 DEBUG 18404 --- [nio-8080-exec-1] o.s.s.w.u.matcher.AntPathRequestMatcher  : Checking match of request : '/'; against '/logout'
2016-08-02 20:30:35.935 DEBUG 18404 --- [nio-8080-exec-1] o.s.security.web.FilterChainProxy        : / at position 7 of 13 in additional filter chain; firing Filter: 'BasicAuthenticationFilter'
2016-08-02 20:30:35.937 DEBUG 18404 --- [nio-8080-exec-1] o.s.s.w.a.www.BasicAuthenticationFilter  : Basic Authentication Authorization header found for user 'u2'
2016-08-02 20:30:35.939 DEBUG 18404 --- [nio-8080-exec-1] o.s.s.authentication.ProviderManager     : Authentication attempt using org.springframework.security.authentication.dao.DaoAuthenticationProvider
2016-08-02 20:30:35.940 DEBUG 18404 --- [nio-8080-exec-1] o.s.s.a.dao.DaoAuthenticationProvider    : User 'u2' not found
2016-08-02 20:30:35.941 DEBUG 18404 --- [nio-8080-exec-1] o.s.s.w.a.www.BasicAuthenticationFilter  : Authentication request for failed: org.springframework.security.authentication.BadCredentialsException: Bad credentials
2016-08-02 20:30:35.941 DEBUG 18404 --- [nio-8080-exec-1] s.w.a.DelegatingAuthenticationEntryPoint : Trying to match using RequestHeaderRequestMatcher [expectedHeaderName=X-Requested-With, expectedHeaderValue=XMLHttpRequest]
2016-08-02 20:30:35.941 DEBUG 18404 --- [nio-8080-exec-1] s.w.a.DelegatingAuthenticationEntryPoint : No match found. Using default entry point org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint@32c6200d
2016-08-02 20:30:35.941 DEBUG 18404 --- [nio-8080-exec-1] w.c.HttpSessionSecurityContextRepository : SecurityContext is empty or contents are anonymous - context will not be stored in HttpSession.
2016-08-02 20:30:35.942 DEBUG 18404 --- [nio-8080-exec-1] s.s.w.c.SecurityContextPersistenceFilter : SecurityContextHolder now cleared, as request processing completed