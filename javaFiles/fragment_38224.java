@Override
public void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException {
    String[] record = value.toString().split(",");

    // Key
    String stg_table = null;
try{
    String report_code = record[0].trim();
    String product_type_description = null;
    String principal_amount = record[1];
    String funded = record[2].trim();
    String facility_id = record[3];
    String loan_id = record[4];

    // Start Date
    String start_date = record[5];

    // Maturity Date
    String end_date = record[6];



DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
Date startDate;
Date endDate;
long diff;
long diffDays = 0l;

try {
    startDate = df.parse(start_date);
    endDate = df.parse(end_date);
    df.format(startDate);
    df.format(endDate);
    diff = endDate.getTime() - startDate.getTime();
    diffDays = diff / (24 * 60 * 60 * 1000);
} catch (ParseException e) {
    e.printStackTrace();
}

// Date Diff
String date_diff = String.valueOf(diffDays);

String next_reset_date = record[7];
String interest_rate = record[8];
String base_interest_rate = record[9];
String counterparty_industry_id = record[10];
String industry_name = record[11];
String counterparty_id = record[12];
String counterparty_name = record[13];

// Bank Number
String vehicle_code = record[14];

String vehicle_description = record[15];

// Branch Number
String cost_center_code = record[16];

String branch_borrower_name = record[17];
String igl_code = record[20];

// Participation Bal Begin Month
String participated_amt = record[21];

String sys_id = record[23];

// Loan To Value
String ltv = record[26];

String accrual_status = record[27];
String country_code = record[30];
String fiscal_year = record[31];
String accounting_period = record[32];
String accounting_day = record[33];
String control_category = record[34];

}
    catch (Exception e) {
if {record.size() > 0} {
    // LOG.warn(String.format("Invalid data in row: %s", record[0].trim()));
    System.out.println(String.format("Invalid data in record id: %s", record[0].trim()));}
else{
System.out.println("Empty Record Found");
}
    return void;
}
...