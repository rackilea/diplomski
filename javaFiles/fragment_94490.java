@ModelAttribute("myHeaderHolder")
public Something addSomething(@RequestHeader(value = "sample") String sample,
    @RequestHeader(value = "sample1") String sample1,
    @RequestHeader(value = "sample2") String sample2,
    @RequestHeader(value = "sample3") String sample3,
    @RequestHeader(value = "sample4") String sample4) {
    return new MyHeaderHolder(name);
}