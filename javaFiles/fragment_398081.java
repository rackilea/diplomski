String stringToBreak = null;
while ((stringToBreak = infileCust.readLine()) != null) {
     //split up the string with string tokenizer
     StringTokenizer st = new StringTokenizer(stringToBreak);
     firstName = st.nextToken();
     lastName =  st.nextToken();
     custId = Integer.parseInt(st.nextToken());
}