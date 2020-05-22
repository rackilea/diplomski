class MyProfileDto {

    @JsonDeserialize(converter = SkillConverter.class)
    private List<String> skills;

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}