@RequestMapping(value="/do-login", method = RequestMethod.POST)
    public void doLogin (@ModelAttribute("authEntity") final AuthEntity authEntity,
                         final Model model,
                         HttpServletResponse servletResponse) throws IOException {
        ...

        String rUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/").build().toUriString();
        servletResponse.sendRedirect(rUrl);
    }