inHouseBtn.setOnAction(inHouseSpecificEvent ->
    {

        grid1.add(machineIDLabel,0,8,1,1);
        grid1.add(machineIDField,1,8,1,1);

        grid1.getChildren().remove(companyLabel);
        grid1.getChildren().remove(companyNameField);
    });


    outSourceBtn.setOnAction(outSourceSpecificEvent ->
    {

        grid1.add(companyLabel,0,8,1,1);
        grid1.add(companyNameField,1,8,1,1);

        grid1.getChildren().remove(machineIDLabel);
        grid1.getChildren().remove(machineIDField);
    });