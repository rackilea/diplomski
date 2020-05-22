// get clicks and payments
Dataset<Row> clickToPayTripDF = df.where(col("eventid").equalTo("ClickToPayTrip"));
Dataset<Row> submitPaymentDF = df.where(col("eventid").equalTo("SubmitPayment"));

// join
Dataset<Row> joined = clickToPayTripDF.alias("click")
    .join(submitPaymentDF.alias("payment"), clickToPayTripDF.col("userid").equalTo(submitPaymentDF.col("userid")), "left");
// filter
Dataset<Row> result = joined
    .withColumn("clickSeconds", to_timestamp(col("click.ts"), "dd/MM/yyyy HH:mm:ss").cast("long"))
    .withColumn("paymentSeconds", to_timestamp(col("payment.ts"), "dd/MM/yyyy HH:mm:ss").cast("long"))
    .where(
        col("payment.eventid").isNull().or(
            expr("paymentSeconds-clickSeconds > 600")
        ))
    .drop("clickSeconds", "paymentSeconds")
    .select("click.userid", "click.ts", "click.eventid");

result.show(false);