Collections.sort(ls, new Comparator() 
                           {

                            public int compare(Object o1, Object o2) 
                            {
                            String sa = (String)o1;
                            String sb = (String)o2;

                            int v = sa.compareTo(sb);

                            return v;           

                                // it can also return 0, and 1
                            }
                           }    
                    );