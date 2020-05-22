public List<CrimeRecord> getAllCrimeRecords(@RequestParam String startDate, @RequestParam String endDate) {
        List<CrimeRecord> cr = new ArrayList<CrimeRecord>();
        try {

            for (int i = 0; i < (crds.getAll(startDate, endDate)).size(); i++) {
               cr.add(crds.getAll(startDate, endDate).get(i));
            }

        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(CrimeRecordController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cr;
    }