//hardware
hardwareStatus.setText("") // Clear old response data from TextView
for (int i = 0; i < response.body().getHardware().length; i++){
  // Your logic
}

//software
softwareStatus.setText("") // Clear old response data from TextView
for (int i = 0; i < response.body().getSoftware().length; i++){
  // Your logic
}