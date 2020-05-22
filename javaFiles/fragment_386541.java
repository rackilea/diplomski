String[] strings = {
        "pot-1_Sam",
        "pot_444_Jack",
        "pot_US-1_Sam",
        "pot_RUS_444_Jack",
        "pot_UK_3_Nick_Samuel",
        "pot_8_James_Baldwin",
        "pot_8_Jack_Furleng_Derik"
};

Pattern pattern = Pattern.compile("\\d_(\\w+)$");
for (String s : strings ){
    Matcher matcher = pattern.matcher(s);
    if (matcher.find()) {
        System.out.println(matcher.group(1));
    }
}