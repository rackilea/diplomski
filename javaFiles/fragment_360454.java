FirstEntity firstEntity = mapper.toEntity(firstDto);
if(firstDto.getSecond() != null) {
    firstEntity.getSecond().setFirst(first);
}

firstRepository.merge(firstEntity);