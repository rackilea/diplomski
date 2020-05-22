public class ResultClass {

        public String type;
        public String tags;
        public ArrayList<String> listTags = new ArrayList<String>();

    }

    public class class2 {


        public String type;
        public String tag;

    }
    public class class1 {


        public String type;

    }
ParseQuery<ParseObject> hashtag = ParseQuery.getQuery("HashTagType");
        hashtag.whereExists("TypeName");

        hashtag.findInBackground(new FindCallback<ParseObject>()

        {

            public void done(List<ParseObject> NameList, ParseException e)

            {

                if (e == null)

                {
                    if (NameList.size() > 0) {

                        for (int i = 0; i < NameList.size(); i++) {

                            // parsedata map = new parsedata();

                            ParseObject p = NameList.get(i);
                            String name = p.getString("TypeName");
                            Log.e("tyhpe name", "" + name);
                            // String tagid=p.getObjectId();

                            class1 c1 = new class1();
                            c1.type = "" + name;
                            listClass1.add(c1);

                            Hashtagtypes.add(name);

                        }

                        Log.d("hastags", listClass2.toString());

                        ParseQuery<ParseObject> query = ParseQuery
                                .getQuery("HashTag");
                        query.whereExists("Tag");
                        query.orderByAscending("Type");
                        query.setLimit(1000);

                        query.findInBackground(new FindCallback<ParseObject>() {

                            @Override
                            public void done(List<ParseObject> list,
                                    ParseException e) {
                                // TODO Auto-generated method stub

                                if (e == null)

                                {
                                    if (list.size() > 0) {

                                        for (int i = 0; i < list.size(); i++) {

                                            ParseObject p = list.get(i);

                                            String tagid = p.getString("Tag");
                                            String Type = p.getString("Type");

                                            class2 c2 = new class2();

                                            Log.e("hashtype", tagid);
                                            Log.e("hashtag", Type);

                                            c2.type = "" + Type;
                                            c2.tag = "" + tagid;
                                            listClass2.add(c2);



                                        }

                                    }

                                    for (int i = 0; i < listClass1.size(); i++) {
                                        ResultClass result = new ResultClass();
                                        result.type = listClass1.get(i).type;
                                        result.tags = "";
                                        Log.e("size at pos : " + i,
                                                listClass2.size() + "");

                                        for (int j = 0; j < listClass2.size(); j++) {
                                            if (listClass1.get(i).type
                                                    .equals(listClass2.get(j).type)) {
                                                result.listTags.add(listClass2
                                                        .get(j).tag);

                                                result.tags += (listClass2
                                                        .get(j).tag + ",");

                                                // --removing from list for
                                                // performance reason
                                                listClass2.remove(j);

                                            }
                                        }

                                        listResult.add(result);

                                    }