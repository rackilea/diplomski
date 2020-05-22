@Resource
UserTransaction tran;

...

public void confirmData (){

    tran.begin();
    try {
        ejbFacadeSM.create(selectedSM);
        ejbFacadeCM.create(selectedCM)
        ejbFacadeAM.create(selectedAM);
        ejbFacadePM.create(selectedPM);

        // Create's succeeded, commit transaction.
        tran.commit();
    } catch (Exception e) {
        // Error occurred, rollback transaction
        tran.rollback();
    }
}