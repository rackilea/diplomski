comparator = new Comparator<String>(){
                @Override
                public int compare(final String o1, final String o2){
                    if(o1.isEmpty()) return Integer.MAX_VALUE;
                    else if (o2.isEmpty()) return Integer.MIN_VALUE;

                    else return Integer.valueOf(ModuleConstants.CUSTOM_LIST.indexOf(o1))
                                        .compareTo(
                           Integer.valueOf(ModuleConstants.CUSTOM_LIST.indexOf(o2)));
                }
            };