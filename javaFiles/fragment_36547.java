String selectQry = ("SELECT at_award.aw_award_name as award_name, COUNT(at_cub_awards.ca_id) as award_count" +
    "FROM at_cub_details, at_cub_awards, at_award " + 
    "WHERE at_cub_details.grp_id = ? " +
    "  AND at_cub_details.cd_id = at_cub_awards.cd_id " +
    "  AND at_cub_awards.aw_id = at_award.aw_id " +
    "  AND (at_award.aw_award_name LIKE '%Bronze Boomerang%' or " +
    "       at_award.aw_award_name LIKE '%Silver Boomerang%') " +
    "GROUP BY at_award.aw_award_type";