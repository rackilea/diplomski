String tname = team_list.get(i).getTeamname();
        String topponent = team_list.get(i).getTeamopponent();
        String tdate111 = team_list.get(i).getTeamdate();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+9"));
        Date datex = null;
        try {
            datex = sdf.parse(tdate111);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String tdate = sdf.format(datex);

        System.out.println(tdate);


        TeamModel _TeamModel = new TeamModel();

        _TeamModel.setTeamname(tname);
        _TeamModel.setTeamopponent(topponent);
        _TeamModel.setTeamdate(tdate);

        _teamlist.add(_TeamModel);