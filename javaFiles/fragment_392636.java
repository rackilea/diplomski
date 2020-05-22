public static void Result() {
    if (AddMatriceCalc.flag == 1) {
        noAddMatriceResult.setVisibility(View.GONE);
        layoutResultCalc.setVisibility(View.VISIBLE);

        for (i = 0; i < MatriceActivity.m; i++) {
            layoutresmap.put("layout" + i, new LinearLayout((Context) activity));
        }
        layoutreslist = new ArrayList<LinearLayout>(layoutresmap.values());

        for (i = 0; i < o; i++) {
            textviewresmap.put("textview" + i, new TextView((Context) activity));
        }
        textviewreslist = new ArrayList<TextView>(textviewresmap.values());

    }
}