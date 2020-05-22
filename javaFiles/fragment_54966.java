public static void main(String[] args) throws IOException {

    String[] stringArr = { "'be in'('force', 'the closed area').",
            "'advise'('coxswains', 'mr mak').",
            "'be'('a good', 'restricted area').",
            "'establish from'('person \'s id', 'the other')." };
    int i = 0;
    Pattern p = Pattern.compile("'(.*?)'(?![a-zA-Z])");
    String[][] arr = new String[4][3];
    for (int count = 0; count < stringArr.length; count++) {
        Matcher m = p.matcher(stringArr[count]);
        int j = 0;
        while (m.find()) {

            arr[i][j++] = m.group(1);
        }
        i++;

    }

    for (int k = 0; k < arr.length; k++) {
        for (int j = 0; j < arr[k].length; j++) {
            System.out.println("arr[" + k + "][" + j + "] " + arr[k][j]);
        }
    }

}