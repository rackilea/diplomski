if ((int) scores_unsorted.get(i) == score) {
    int score_index = scores_unsorted.indexOf(Integer.valueOf(score));       
    System.out.println(order+")"+names_unsorted.get(score_index).toString()+": "+score);
    scores_unsorted.remove(score_index);
    names_unsorted.remove(score_index);
    break;
}