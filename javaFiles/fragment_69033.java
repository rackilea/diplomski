String reportsStr = "";

for(int i = 0; i < reports.size(); i++) {
    reportStr += reportName;
    if(i != reports.size() - 1) {
        reportsStr += "|";
    }
}

NameValuePair nvPair = new NameValuePair("reports", reportsStr);