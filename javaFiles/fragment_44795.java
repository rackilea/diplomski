public void fillArray() {
    try (InputStream is = getResources().openRawResource(R.raw.quiz_questions)) {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String nextLine;
        int i = 0, j = 0;
        while ((nextLine = br.readLine()) != null) {
            if (j == 5) {
                j = 0;
                i++;
            }
            questions[i][j] = nextLine;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}