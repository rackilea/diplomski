@GetMapping(path = "/oldapi/...")
public Page<MyBean> getBeans(
    @RequestParam(value = "size", required = false) Integer size,
    @RequestParam(value = "pageSize", required = false) Integer pageSize,
    @RequestParam(value = "page", required = false) Integer page,
    @RequestParam(value = "pageIndex", required = false) Integer pageIndex,
    ...
) {
    Integer pSize = pageSize != null ? pageSize : size;
    Integer pIndex = pageIndex != null ? pageIndex : page;
    ...
}