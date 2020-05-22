this.textAbsType.Click += (object sender, EventArgs e) => {

    Dialog absenceTypeDialog = new Dialog(context);
    absenceTypeDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    absenceTypeDialog.setContentView(R.layout.AbsenceTypePopup);
    absenceTypeDialog.Show();

    this.btnAbsTypePopupClose = absenceTypeDialog.FindViewById<Button> (Resource.Id.btnAbsTypePopupClose);

    this.btnAbsTypePopupClose.Click += (object sender2, EventArgs e2) => {
        absenceTypeDialog.Dismiss();
    };
};