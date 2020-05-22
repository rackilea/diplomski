try {
    UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

    SecurityContextHolder.getContext().setAuthentication(authentication);
    chain.doFilter(req, res);
}catch (Exception e){


    res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    res.getWriter().write(convertObjectToJson(e));
}