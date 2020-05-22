StringTokenizer st = new StringTokenizer(savedString, ",");
mListEmailAddresses = new ArrayList<String>();
while (st.hasMoreTokens()) {

     String strEmail = st.nextToken();
     mListEmailAddresses.add(strEmail);
}