// (I assume that agents is a list)
//this will define placeholders for example (?, ?, ?) if you have 3 agents
String inClause = "(" + String.format("%0" + agents.size() + "d", 0)
    .replace("0", "?, ").replaceFirst(", $", ")");

String query = String.format("SELECT surveys_nps_rating, survey_agent_name, surveys_stream_item_key "
                + "FROM public.surveys "
                + "WHERE surveys_response_date BETWEEN ? AND ? "
                + "AND survey_agent_name IN %s", inClause);