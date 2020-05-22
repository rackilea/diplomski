List<List<String>> arrayst = new ArrayList<List<String>>();
     List<List<String>> arrayqu = new ArrayList<List<String>>();
     List<List<String>> arrayya = new ArrayList<List<String>>();

     List<String> items = Arrays.asList(line.split(":",-1));
StackOverflow st=new StackOverflow();
st.compare(items,arrayst);
st.compare(items,arrayqu);
st.compare(items,arrayya);