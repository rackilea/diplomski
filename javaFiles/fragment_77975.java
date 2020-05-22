private Task<List<RestCanvas>> fetchCanvases = new MyTask(getCanvasForGroupAccount + groupAccount.getGroupId());

// ...

// please don't use this name :)
private static class MyTask extends Task<List<RestCanvas>> {
    private final String id;

    public MyTask(String id) {
        this.id = id;
    }

    @Override
    protected List<RestCanvas> call() throws Exception {
        List<RestCanvas> list = new ArrayList<>();
        try{
            for(RestGroupAccount groupAccount : groupAccounts) {
                RestTemplate rest = StaticRestTemplate.getRest();
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.add("Cookie", "JSESSIONID=" + StaticRestTemplate.jsessionid);
                HttpEntity<RestCanvas> requestEntity = new HttpEntity<>(requestHeaders);
                rest.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                rest.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                ResponseEntity<RestCanvas[]> responseEntity = rest.exchange(id, HttpMethod.GET, requestEntity, RestCanvas[].class);
                RestCanvas[] restCanvasArray = responseEntity.getBody();
                Collections.addAll(list, restCanvasArray);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        return list;
    }
}