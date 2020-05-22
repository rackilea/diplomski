ArrayList<Object> ret = new ArrayList<Object>(new Object[] {
            visit.getIdVisit(),
            visit.getProfession().getProfessionName(),
            visit.getSpiProfessional().getFullName(),
            RegularFunctions.getTimeFormat().format(visit.getVisitDate()),
            RegularFunctions.toNormalCapitalizedText(visit.getVisitState()
                    .toString()), visit.getReason()
            // don't add Edit item at all yet
            })

if(editable)
     ret.add("Edit");

return ret.toArray();