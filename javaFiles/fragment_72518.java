public Configuration createConfiguration(){

    Configuration configBroad = new Configuration();

    String configName = getResources().getString(R.string.config_broad_name);
    String refPatternName = getResources().getString(R.string.config_broad_pattern);
    refPatternName = refPatternName.replace("@",""); //removing @-prefix
    int refPatternId = Integer.parseInt(str); //this value now is the same as R.array.pattern_a


    configBroad.setName(configName);
    configBroad.setPatternId(refPatternId);

    return configBroad;
}