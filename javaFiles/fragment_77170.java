@Test
@WithMockUser(username = "V", authorities = {"USER"})
public void addItemToShoppingCart() throws Exception {
    CartItem cartItem = new CartItem();

    String qty = "2";

    Book book = new Book();
    book.setActive(true);

    User user = new User();
    book.setId(1L);
    book.getId();

    cartItem.setBook(book);

    expect(userService.findByUsername("valentine")).andReturn(user);

    expect(bookService.findOne(anyLong())).andReturn(book);

    expect(cartItemService.addBookToCartItem(book, user, Integer.parseInt(qty))).andReturn(cartItem);
    replay();

    ObjectMapper objectMapper = new ObjectMapper();
    mockMvc
            .perform(get("/shoppingCart/addItem")
                    .accept(MediaType.TEXT_HTML)
                    .contentType(MediaType.TEXT_HTML)
                    .param("book", objectMapper.writeValueAsString(book))
                    .param("qty", qty))


            .andExpect(model().attribute("book", book))
            .andExpect(model().attribute("qty", qty))
            .andExpect(model().attribute("addBookSuccess", true))

            .andExpect(view().name("forward:/bookDetail?id=" + cartItem.getId()))
            .andReturn();
}