String s="{1,2,3,4,5}";
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(s);
        List<Integer> list=new ArrayList<Integer>();
        while (m.find()) {
          Integer num=new Integer(m.group());

          list.add(num);
        }

        System.out.println(list);