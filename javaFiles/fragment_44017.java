boolean assertionOn = false;
assert assertionOn = true;
if (assertionOn) {
   assumeDataIsGood(); // due to checks elsewhere
} else {
   expensiveCheckThatDataMightNotBeGood();
}