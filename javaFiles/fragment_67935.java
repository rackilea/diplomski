ObjectMapper mapper = new ObjectMapper();
mapper.getDeserializationConfig().addMixInAnnotations(Family.class, FamilyMixin.class);

Family family = mapper.readValue(json, Family.class);
Member member = (Member) family.getMembers().get(0);

//...

interface FamilyMixin {
    @JsonDeserialize(contentAs = Member.class)
    void setMembers(List members);
}