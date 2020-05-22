public TreeItem<String> randomBranch(TreeItem<String> parent) {

    Random rand = new Random();
    int listNum = parent.getChildren().size();

    int num;
    TreeItem<String> getIT;

    do {
        num = rand.nextInt(listNum) + 0;
        getIT = parent.getChildren().get(num);
    } while (!getIT.toString().contains("=s="));

    return getIt;
}