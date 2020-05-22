if(radioButtonLF.isSelected() || radioButtonLF2.isSelected() || radioButtonT.isSelected() || radioButtonLH.isSelected()){
     WorkerTime workerTime = new WorkerTime();
     workerTime.execute();
}
if(!fTextFieldSB.getText().equals("")){
     WorkerSB workerSB = new WorkerSB();
     workerSB.execute();
}  
if(!fTextFieldP.getText().equals("")){
     WorkerPB workerPB = new WorkerPB();
     workerPB.execute();
}