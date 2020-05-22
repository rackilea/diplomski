public MyServerResource extends ServerResource {
    private boolean hasRole(String expectedRole) {
        List<Role> roles = request.getClientInfo().getRoles();
        for (Role role : roles) {
            if (role.getName().equals(expectedRole)) {
                return true;
            }
        }
        return false;
    }

    private void checkRole(String role) {
        if (!hasRole(role)) {
            throw new ResourceException(
               Status.CLIENT_ERROR_FORBIDDEN);
        }
    }

    @Get
    public Representation getElement() {
        checkRole("read");
    }

    @Put
    public void updateElement(Representation repr) {
        checkRole("update");
    }

    @Delete
    public void deleteElement() {
        checkRole("delete");
    }
}