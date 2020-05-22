VendorObject vo = mock(VendorObject.class, new Answer() {
    @Override
    public Object answer(InvocationOnMock invocation) {

        // 1. Check if method exists on RedirectToObject.
        // 2a. If it does, call the method with the args and return the
        // result.
        // 2b. If it does not, throw an exception to fail the unit test.

    }
});