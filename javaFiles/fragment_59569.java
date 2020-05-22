SecurityContext securityContext = SecurityContextHolder.getContext();
securityContext.setAuthentication(authentication);

// Create a new session and add the security context.
HttpSession session = request.getSession(true);
session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);