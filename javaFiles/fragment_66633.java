@RequestMapping(value = "/data", params="name", method = RequestMethod.GET)
  public @ResponseBody String getData(@RequestParam(value="name") String name) {
    InputStream in = new FileInputStream("/real/path/" + name);
    String contents = IOUtils.toString(in, "UTF-8");
    return contents;
  }