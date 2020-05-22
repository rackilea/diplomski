String notExistingId = "999";
String newUserName = "newUser";
this.mockMvc.perform(post("/customer/register")
        .param("id", notExistingId)
        .param("username", newUserName)
        .param("password", "123")
        .param("emailAddress", "testIgnored@gmail.com")
        .param("address.country", "RU")
        .param("address.city", "Nsk")
        .param("address.street", "Lenin"))
        .andExpect(model().hasNoErrors())
        .andExpect(view().name("redirect:/index.htm"));
Optional<Account> account = accountService.getAccount(newUserName);
assertTrue( "Account with the username should exist", account.isPresent());
assertNotSame("Account id should not be equal to the id we try to pass with parameters",
        Long.parseLong(notExistingId),
        account.get().getId());