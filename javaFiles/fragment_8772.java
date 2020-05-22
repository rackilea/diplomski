finish = false;
while (!finish) {
    //customWord = scan.nextLine();
    if (customWord.equals(ranWord)) {
        System.out.println("Succsesful prompt!");

    } else {
        checkIsFinish(customWord, ranWord);
    }
    finish = true;

}