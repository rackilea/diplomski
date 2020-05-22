for(i = 0;i<officePositionAndColumn.length;i++)
    {
        //se l'id che era stato impostato è uguale a quello passato 
        if(officePositionAndColumn[i] [0] == panelSelected.getOffice().getId())
            //posizione della colonna che va da 0 a n.
            columnPosition = officePositionAndColumn[i][1];
    }
    //se è stato trovata la posizione della colonna
    if(columnPosition>=0) {
        //mi ricavo la colonna 
        DashboardColumn columnSelected = new DefaultDashboardColumn();
        columnSelected = columnDashboard.get(columnPosition);
        //imposto l'id al widget
        columnSelected.addWidget(idWidget);
        //sovrascrivo la colonna con quella modificata
        columnDashboard.set(columnPosition, columnSelected);
        //reimposto il modello e ricarico le colonne
        setModel(new DefaultDashboardModel());
        for(i = 0;i<columnDashboard.size();i++)
        {
            this.model.addColumn(columnDashboard.get(i));
        }

        for(i = 0;i<meetingRoomByOffice.size();i++)
        {
            if(meetingRoomByOffice.get(i).equals(panelSelected))
            {
                meetingRoomByOffice.remove(i);
            }
        }