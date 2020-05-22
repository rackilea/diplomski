if(result.getStatus() == ITestResult.SUCCESS)
    {
        System.out.println("Method-"+methodName+"- has Passed");
        this.bookk = writeDataInCell(methodCellColumn+3, methodCellRow,"Pass",bookk);
        System.out.println("Method Column number is-> "+(methodCellColumn+3));
        System.out.println("Method row number is-> "+methodCellRow);
    }
    else if(result.getStatus() == ITestResult.FAILURE)
    {
        System.out.println("Method-"+methodName+"- has Failed");
        this.bookk = writeDataInCell(methodCellColumn+3, methodCellRow,"Fail",bookk);
        System.out.println("Method Column number is-> "+(methodCellColumn+3));
        System.out.println("Method row number is-> "+methodCellRow+"\n");

    }
    else if(result.getStatus() == ITestResult.SKIP)
    {
        System.out.println("Method-"+methodName+"- has Skipped");
        this.bookk = writeDataInCell(methodCellColumn+3, methodCellRow,"Skip",bookk);
        System.out.println("Method Column number is-> "+(methodCellColumn+3));
        System.out.println("Method row number is-> "+methodCellRow);

    }