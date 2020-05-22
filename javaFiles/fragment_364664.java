class Test {
    public void print(RestTemplate restTemplate){
        restTemplate.getForObject("url", String.class);
    }
}

class TestTest {

    private final Test instance = new Test();

    @Test
    public testPrint() {
        RestTemplate restTemplateMock = mock(RestTemplate.class);

        instance.print(restTemplateMock);

        // TODO: verify method calls on the mock
    }
}