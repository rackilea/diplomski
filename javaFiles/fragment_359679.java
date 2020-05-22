this.appointments().addAll(getTimeTable().getCreneauxsList().stream()
                .filter(e->compareNullableString(e.getProf,prof) )
                .filter(e->compareNullableString(e.getCours,cours))
                .filter(e->compareNullableString(e.getSalle,salle) )
                .filter(e->compareNullableString(e.getGroup,group) )
                .collect(Collectors.toList()));