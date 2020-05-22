log.info("Query results:");
Terms contractSums = response.getAggregations().get("customer_id");
for (Terms.Bucket bucket : contractSums.getBuckets()) {
    Sum aggValue = bucket.getAggregations().get("total_contract_sum");
    DecimalFormat formatter = new DecimalFormat("0.00");
    log.info("  " + bucket.getKey() + " " + formatter.format(aggValue.getValue()));
}