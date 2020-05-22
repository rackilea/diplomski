boolean showError = false;
try{
    double r = Double.parseDouble(rate.getText());

    if (r >= 6 && r <= 150){
        test.setRate(r);
    }else{
       showError = true;
    }
} catch(NumberFormatException e){
     showError = true;
}

if(showError){
    JOptionPane.showMessageDialog(null, "Sorry, hourly rate must be between $6 and     $150.");
}