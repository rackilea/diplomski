String output = getCategoryServiceController.myGetCategory();
LOGGER.debug("output {} ", output

GetCategoryResponseDto dto = mapper.readValue(json, GetCategoryResponseDto.class

return Optional.of(dto);