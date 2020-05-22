private List<AsignoreTypes> getAssignoreTypesList(final String sql) {
    final List<AsignoreTypes> result = new ArrayList<AsignoreTypes>();
    final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    final Session session = service.getDataServiceManager().getSession();
    final Query query = session.createQuery(sql);
    final List<?> rows = query.list();
    for (final Object row : rows) {
        final Object[] columns = (Object[]) row;
        final AsignoreTypes ass = new AsignoreTypes();
        ass.setFirstname((String) columns[0]);
        ass.setLastname((String) columns[1]);
        if (columns[2] != null) {
            try {
                ass.setDoa(formatter.parse(columns[2].toString()));
            } catch (final ParseException e) {
                // ignore?
            }
        }
        result.add(ass);
    }

    return result;
}

public void foo()
{
    final List<AsignoreTypes> assignorInfos = getAsignoreTypesList("select upper(ass.firstName), upper(ass.lastName), ass.doa from AssignorInfo ass");
    log(INFO, "List one size " + assignorInfos.size());

    final List<AsignoreTypes> generalInfos = getAsignoreTypesList("select upper(g.fname), upper(g.lname), g.doa from  GeneralInfo g where g.arbitrator like '%Bulel%' ");
    log(INFO, "Size from wizard " + generalInfos.size());

    final List<AsignoreTypes> filtered = new ArrayList<AsignoreTypes>();
    for (final AsignoreTypes asignoreTypes : generalInfos) {
        if (!assignorInfos.contains(asignoreTypes)) {
            filtered.add(asignoreTypes);
            log(INFO, "Got matching element " + asignoreTypes.getLastname());
        }
    }

    log(INFO, "Filtered : " + filtered.size() + "/" + generalInfos.size());
}