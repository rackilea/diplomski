@RequestMapping(...)
public void foo(@RequestHeader(name="Accept", required=false) String accept) {
    //                                        ↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    //                                           Missing!
    ...
}