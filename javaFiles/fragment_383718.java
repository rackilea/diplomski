public static List<String> tokenize(String line){
    List<String> result = Lists.newArrayList();
    StringTokenizer st = new StringTokenizer(line, "\t");
    st.nextToken(); //get rid of the first token
    result.add(st.nextToken()); //show me the second token
    st.nextToken(); //get rid of the third token
    result.add(st.nextToken()); //show me the fourth token
    return result;
  }

  static final Splitter splitter = Splitter.on('\t');
  public static List<String> guavaSplit(String line){
    List<String> result = Lists.newArrayList();
    int i=0;
    for(String str : splitter.split(line)){
      if(i==1 || i==3){
        result.add(str);
      }
      i++;
    }
    return result;
  }

  static final Pattern p = Pattern.compile("^(.*?)\\t(.*?)\\t(.*?)\\t(.*)$");
  public static List<String> regex(String line){
    List<String> result = null;
    Matcher m = p.matcher(line);
    if(m.find()){
      if(m.groupCount()>=4){
        result= Lists.newArrayList(m.group(2),m.group(4));
      }
    }
    return result;
  }

  public static List<String> homeGrown(String line){
    List<String> result = Lists.newArrayList();
    String subStr = line;
    int cnt = -1;
    int indx = subStr.indexOf('\t');
    while(++cnt < 4 && indx != -1){
      if(cnt==1||cnt==3){
        result.add(subStr.substring(0,indx));
      }
      subStr = subStr.substring(indx+1);
      indx = subStr.indexOf('\t');
    }
    if(cnt==1||cnt==3){
      result.add(subStr);
    }
    return result;
  }