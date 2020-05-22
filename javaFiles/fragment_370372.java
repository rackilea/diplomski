String json = "{\"id\":213213213, \"amount\":222}";
when(request.getInputStream()).thenReturn(
    new DelegatingServletInputStream(
        new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8))));
when(request.getReader()).thenReturn(
    new BufferedReader(new StringReader(json)));
when(request.getContentType()).thenReturn("application/json");
when(request.getCharacterEncoding()).thenReturn("UTF-8");