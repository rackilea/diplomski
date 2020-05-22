@RequestMapping(method = POST, value = "/api/applicants/getMatchedApplicants")
public List getMatchedApplicants(@RequestBody HashMap property) {

    List<Applicant> applicants = applicantRepository.matchedApplicants((int) property.get("typeId"),
                                                                        (int) property.get("bedrooms"),
                                                                        (int) property.get("price"));

    return applicants == null ? new ArrayList() : applicants;
}