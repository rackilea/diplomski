private void calculateMerchantTotals()
{
    double dayAmount = 0;
    DayOfWeek previousDay = null;
    String previousName = "";

    for( Merchant merchant : merchantList )
    {
        for( Payment payment : merchant.getPayments() )
        {
            if( payment.getPaymentDue().get(ChronoField.CLOCK_HOUR_OF_DAY) >= 16 && payment.getPaymentDue().get(ChronoField.CLOCK_HOUR_OF_DAY) != 24 )
            {
                payment.setPaymentDue( payment.getPaymentDue().plusDays(1) );
            }

            dayAmount += payment.getAmount();

            // The newly injected condition here
            if(previousDay == null)
               previousDay = payment.getPaymentDue().getDayOfWeek();

            if( !payment.getPaymentDue().getDayOfWeek().equals( previousDay ) )
            {
                dayAmount = Math.round(dayAmount * 100.0) / 100.0;
                tableDataList.add( new TableData( previousDay, previousName, dayAmount ) );
                dayAmount = 0;
            }

            previousDay = payment.getPaymentDue().getDayOfWeek();
            previousName = merchant.getMerchantName();
        }
    }
    // For adding the last day into the list
    tableDataList.add( new TableData( previousDay, previousName, dayAmount ) );

    System.out.println( tableDataList );
}