RequestBuilder request = get("/110")
    .with(user(rob).roles("USER"));

mvc
    .perform(request)
    .andExpect(status().isUnAuthorized());