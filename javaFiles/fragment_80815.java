String text =
              "FROM dt_dim AS d, "+
              "adj_dim AS adj " +
              "cam_dim AS cam, " +
              "agg_day_adv_campaign_demand_fact AS fact ";

    Pattern FACT_PAT = Pattern.compile("(\\S+_fact)");
    Matcher m = FACT_PAT.matcher(text);
    if (m.find()){
        System.out.println(m.group(1));
    }