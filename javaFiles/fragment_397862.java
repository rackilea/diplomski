$("#projectTeams").change(function () {
        onTeamSelect($(this).val());
    }); 
    function onTeamSelect(teamId){
        myTeamId = teamId;
        oTable.fnDraw();
    }