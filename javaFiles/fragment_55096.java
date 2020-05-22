public interface ProfileData {
    @XBRead("/root/personal_data/resultSet/firstname")
    String getFirstName();
    @XBRead("/root/personal_data/resultSet/surname")
    String getSurname();

    @XBRead("/root/personal_data/resultSet/core_areas")
    String getCoreAreas();

    interface Skill {
        @XBRead("skillname")
        String getName();
        @XBRead("skillval")
        String getExperience();
    }
    interface SkillSet {
        @XBRead("../gencatname")
        String getGenericCategory();
        @XBRead("catname")
        String getCategory();
        @XBRead("skill")
        List<Skill> getSkills();
    }

    @XBRead("/root/skills/tab/category")
    List<SkillSet> getSkillSets();
}