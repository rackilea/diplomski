@RequestMapping("/vegetables/{name}")
public String vegetablesNames(@PathVariable String name){

    if (name.matches("your regex") {
        throw new RuntimeException(name + " doesn't match");
    }
    return "vegetables";
}