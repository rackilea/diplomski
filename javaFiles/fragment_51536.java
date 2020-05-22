String keySkills = "";

if(skill != null && !skill.isEmpty()){
    for (int i = 0; i < skill.size(); i++) {
        if (skill.get(i).getSkillName() != null && !skill.get(i).getSkillName().isEmpty()) {
            keySkills = keySkills+", "+ skill.get(i).getSkillName();
        }
    }

    if(keySkills.isEmpty())
        keySkills = "Not Specified";
}else {
    keySkills = "Not Specified";
}

if(keySkills.equals("Not Specified")
    tvKeySkills.setTextColor(getResources().getColor(R.color.color_three));
else
    keySkills = keySkills.subString(2); // handle initial ',' with a space

tvKeySkills.setText(keySkills);