@Test
public void test_handle() {
    Cookie[] cookieArr = {new Cookie("fname","ram")};
    when(request.getCookies()).thenReturn(cookieArr);
    service.handle(request, response);
    verify(response).addCookie(any());
    verify(response).addHeader("message", "No cookies found");
}