public void genericForEachLoop(POITextExtractor te, String[] tagArrays, List<String>... lists ) {

    int i = 0;
    for(List<String> list : lists) {    

        System.out.println(tagArrays[i]);                   
        for (String item : list) {

            if (te.getText().contains(item)) {
                System.out.println(item);
            }

        }

     i++;
    }
}