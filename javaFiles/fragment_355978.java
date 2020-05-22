@GetMapping("/data")
public DataResponse getData() {
    List<Data> results = dataService.list();
    DataResponse response = new DataResponse ();
    response.setSuccess(true);
    response.setCount(results.size());
    response.setData(results);
    return response;
}