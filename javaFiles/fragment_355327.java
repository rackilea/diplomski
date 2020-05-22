XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(
                destinationSheet);
XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper
                .createIntegerConstraint(OperatorType.EQUAL, "0", "10");
CellRangeAddressList addressList = new CellRangeAddressList(7,
                destinationSheet.getLastRowNum() + 1, 9, destinationSheet
                        .getRow(0).getLastCellNum());
XSSFDataValidation validation = (XSSFDataValidation) dvHelper
                .createValidation(dvConstraint, addressList);

validation.setErrorStyle(ErrorStyle.STOP);
validation.createErrorBox("Error", "Only numeric values are allowed");
validation.setShowErrorBox(true); // The code is missing this line

destinationSheet.addValidationData(validation);