@RequestMapping(value = GET_MAP , method = RequestMethod.GET)
public @ResponseBody Resource getMap(@PathVariable("filename")String filename
            ,HttpServletResponse response) throws IOException {
        File file = new File(filename + ".zip");
        return new FileSystemResource(file);
    }