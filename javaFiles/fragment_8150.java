for(y = 0; y < NUM_TEAMS; ++y){
        System.out.println(x);

        for(x = 0; x < NUM_TEAM_MEMBERS; ++x){
            System.out.println(x);
            System.out.println("\nMembers of team " +
                            teams[y].getTeamName());
            // We have an issue here!!!!!!
            System.out.print(teams[y].getMember(x) + " ");
        }
    }