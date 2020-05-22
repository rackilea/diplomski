@RequestMapping(value = "/bookmarkPost", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
          public @ResponseBody InputDto testPost(@RequestBody InputDto inputDto) {
               String age = inputDto.getTestAge();
               String name = inputDto.getTestname();
               InputDto dto = new InputDto();
               dto.setTestAge(age + "gotback");
               dto.setTestname(name + "gotback");
               return dto;
    }