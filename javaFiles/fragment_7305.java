@RequestMapping(value = "users/{id}/projects", method = RequestMethod.POST)
        public HttpEntity<Project> createProject(
                            @PathVariable("id") User user,
                            @RequestParam String formField1,
                            @RequestParam String formfield2)
{

}