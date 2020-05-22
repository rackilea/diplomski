protected CustomUsernamePasswordAuthenticationFilter getAuthenticationFilter() {
    CustomUsernamePasswordAuthenticationFilter authFilter = new CustomUsernamePasswordAuthenticationFilter();
    try { 
        authFilter.setAuthenticationManager(this.authenticationManagerBean());
    } catch (Exception e) {
        e.printStackTrace();
    }
    return authFilter;
}