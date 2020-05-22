class SecurityFilters {
    def filters = {
        overall(controller: '*', action: '*') {
            after = {
                String loc = response.getHeader("Location")
                if (isRequiresHttps()) {
                    response.setHeader("Location", convertToHttps(loc))
                }
            }
        }
    }
    private boolean isRequiresHttps() { ... }
    private String convertToHttps(String url) { ... }
}