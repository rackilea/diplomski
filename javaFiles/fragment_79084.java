@GetMapping(path = "/oldapi/...")
public Page<MyBean> getBeans(
    @RequestParam(required = false) final String blah,
    @RequestParam(value = "pageSize", required = false) Integer pageSize,
    @RequestParam(value = "pageNum", required = false) Integer pageNum,
    @RequestParam(value = "sort", required = false)
) {
    // Create Pageable object from request parameters
    ...
    // Call service or repository with this pageable
    ...
}