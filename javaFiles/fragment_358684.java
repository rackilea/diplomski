submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String webUrl = "http://10.0.3.2:8084/data_web/indoorPatient.jsp?sr_no="
                + ins.sr_no.getText().toString()
                + ""
                + ins.patient_name.getText().toString()
                + ""
                + ins.consultant_name.getText().toString()
                + ""
                + ins.ref_dr.getText().toString()
                + ""
                + ins.department.getText().toString()
                + ""
                + ins.rel_name.getText().toString()
                + ""
                + ins.rel_no.getText().toString()
                + ""
                + ins.arr_date.getText().toString()
                + ""
                + ins.arr_time.getText().toString() + "&submit=Submit";
        new dbwork().execute(webUrl);
    }
});