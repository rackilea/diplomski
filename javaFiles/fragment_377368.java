//Arrange
//...code removed for brevity

// Act
Boolean result = instance.addPropertyToUserWishlist(request, response, propId);

//Assert
ArgumentCaptor<Cookie> cookieCaptor = ArgumentCaptor.forClass(Cookie.class);

//Same as verify(response, times(1)) and captures the passed argument
verify(response).addCookie(cookieCaptor.capture());

Cookie cookie = cookieCaptor.getValue();

int expectedAge = 60 * 60 * 24 * 365 * 5;
String expectedName = "favourites";

assertEquals(expectedAge, cookie.getMaxAge());
assertEquals(expectedName, cookie.getName());
assertEquals(propId, cookie.getValue());