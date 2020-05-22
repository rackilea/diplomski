finish = true;
while (finish) {
    //customWord = scan.nextLine();
    if (customer.word.equals(computer.ranWord)) {
        System.out.println("Succsesful prompt!");

    } else {
        checkIsFinish(customWord, ranWord);
    }
    finish = false;

}