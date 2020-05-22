public int[] front11(int[] a, int[] b) {

    int answerindexs = 0;
    answerindexs = a.length > 0 ? answerindexs + 1 : answerindexs;
    answerindexs = b.length > 0 ? answerindexs + 1 : answerindexs;

    int[] answer = new int[answerindexs];
    //Index variable
    int i = 0;

    for (int x = 0; x <= 1; x++){
        if(a.length > 0 && x == 0)
            answer[i++] = a[0];
        else if(b.length > 0 && x == 1)
            answer[i] = b[0];
    }
    return answer;
}