String searchUrl = "https://www.ariva.de/aktiensuche/_result_table.m";
String searchBody = "page=0&page_size=25&sort=ariva_name&sort_d=asc&ariva_performance_1_year=_&ariva_performance_3_years=&ariva_performance_5_years=&index=0&founding_year=&land=0&industrial_sector=0&sector=0&currency=0&type_of_share=0&year=_all_years&sales=_&profit_loss=&sum_assets=&sum_liabilities=&number_of_shares=&earnings_per_share=&dividend_per_share=&turnover_per_share=&book_value_per_share=&cashflow_per_share=&balance_sheet_total_per_share=&number_of_employees=&turnover_per_employee=_&profit_per_employee=&kgv=_&kuv=_&kbv=_&dividend_yield=_&return_on_sales=_";

// post request to search URL
Document document = Jsoup.connect(searchUrl).requestBody(searchBody).post();

// find links in returned HTML
for(Element link:document.select("a[href]")) {
    System.out.println(link);
}