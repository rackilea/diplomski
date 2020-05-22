// define numbersArrayList as { 1, 2, 3, 4, ... n }
ArrayList<int> yourLottoNumbers = new ArrayList<int>()
for (int i = 0; i < yourLimit; i++)
{
    int randomIndex = (int)(Math.random() * numbersArrayList.length()) - 1;
    int newNumber = numbersArrayList[randomIndex];
    yourLottoNumbers.add(newNumber);
    yourLottoNumbers.remove(randomIndex);
}