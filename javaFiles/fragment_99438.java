@RequestMapping({"/", "/{page:(?!resources).*$}"})
public void pageHandler(@PathVariable("page") Optional<String> page) {
    if (!page.isPresent()) {
        // root
    } else {
        // process page
    }
}