for (TrainingClass tclass : mTrainingClasses) {
        //Loop the ArrayList
        JTextField txtPriority = new JTextField(3);
        txtPriority.setBounds(10,10,100,20);
        txtPriority.setText("" + tclass.getPriority());
        getContentPane().add(txtPriority);
        textFields.add(txtPriority);
}