for (int i = 0; i < catcategory.length; i++) {
            try {
                String _result_word = catcategory[i].replaceFirst("\\\\n", "").replace("*", "");
                //String _result_word=catcategory[i].replaceFirst("\\\\n", "").replace("*", "").replaceFirst("\\\\n", "").replace("*", "");
                System.out.println("" + _result_word);
                list.add(_result_word);
            } catch (Exception ex) {
                System.out.println("Special Exception occurred at index : i = " + i);
                ex.printStackTrace();
            }
        }