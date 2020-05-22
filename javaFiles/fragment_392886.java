public Page<CandidatesDetailsDto> filterCandidates(Integer page, Integer pageSize) {

    page = (page == null || page < 1) ? 0 : page - 1;
    pageSize = (pageSize == null || pageSize < 1) ? 10 : pageSize;

    PageRequest pageRequest = new PageRequest(page, pageSize);

    List<CandidatesEntity> candidatesEntityList2 = candidatesService.findAll(pageRequest);

    int start = (int) pageRequest.getOffset();

    if (start <= candidatesEntityList2.size()) {
      return nonExistentPage(candidatesEntityList2.size()); // important part here
    }
    int end = Math.min(start + pageRequest.getPageSize(), candidatesEntityList2.size());

    candidatesEntity = new PageImpl<CandidatesEntity>(candidatesEntityList2.subList(start, end), pageRequest, candidatesEntityList2.size());

    return candidatesEntity.map(source -> candidatesDetailsConverter.convertTo(source));
}

/*
 * Implement this yourself: you must convey to the user that the page 
 * he requested from you does not exist.
 */
private abstract Page<CandidatesDetailsDto> nonExistentPage(int fullListSize);