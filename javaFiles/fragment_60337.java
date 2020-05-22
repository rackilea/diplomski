Realm realm = null;
try {
    realm = Realm.getDefaultInstance();
    realm.executeTransaction(new Realm.Transaction() {
        @Override
        public void execute(Realm realm) { 
            RealmQuery<RealmCase> query = realm.where(RealmCase.class);
            RealmCase persistedCase = query.findFirst();
            PatientInfo oldPatientInfo = persistedCase.getPatientInfo();
            if(oldPatientInfo != null) {
                oldPatientInfo.removeFromRealm();
            }

            // New Objects either have to be copied first or created using createObject
            PatientInfo newPatientInfo = realm.copyToRealm(new RealmPatientInfo(patientInfo));
            persistedCase.setPatientInfo(newPatientInfo);
        }
    });
} finally {
    if(realm != null) {
       realm.close();
    }
}