ServletResponse response = mock(ServletResponse.class);
    ServletOutputStream servletOut = mock(ServletOutputStream.class);
    when(response.getOutputStream()).thenReturn(servletOut);

    new xlCollaborationService().service(request, response);

    // Capture argument
    ArgumentCaptor<String> bufferCaptor = ArgumentCaptor.forClass(String.class);
    verify(servletOut).print(bufferCaptor.capture());

    String responseBody = bufferCaptor.getValue();
    System.out.println(responseBody);