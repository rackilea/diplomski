@RequestMapping({"/", "/{page:(?!resources).*$}"})
public void pageHandler(@PathVariable(name="page", required=false) String page) {
    if (StringUtils.isEmpty(page)) {
        // root
    } else {
        // process page
    }
}