RadioGroup radGrp = new RadioGroup(mActivity);
    params.weight = 0.2f;
    radGrp.setLayoutParams(params);
    radGrp.setOrientation(RadioGroup.HORIZONTAL);

    String tag = Long.toString(req.getRequirementId()) + "_" +
            getString(R.string.yes);
    RadioButton radioBtnYES = new RadioButton(mActivity);
    radioBtnYES.setText(getString(R.string.yes));
    radioBtnYES.setTag(tag);
    radioBtnYES.setOnClickListener(radioListener);
    radGrp.addView(radioBtnYES);

    tag = Long.toString(req.getRequirementId()) + "_" +
            getString(R.string.no);
    RadioButton radioBtnNO = new RadioButton(mActivity);
    radioBtnNO.setText(getString(R.string.no));
    radioBtnNO.setTag(tag);
    radioBtnNO.setOnClickListener(radioListener);
    radGrp.addView(radioBtnNO);