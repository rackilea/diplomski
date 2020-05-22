@Before
    public void setup()
    {
        Map<String, String[]> mockParameterMap = new HashMap<>();
        mockParameterMap.put("brand00", new String[]{"value01"});
        // add all the parameters you want ...
        Mockito.when(webRequest.getParameterMap())
                .thenReturn(mockParameterMap);
    }