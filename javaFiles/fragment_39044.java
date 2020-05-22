int j = 0;
int passes = 0;
while ((j = (secondLine.indexOf(passed, j) + 1)) > 0) {
    passes++;
    System.out.println(j);
    feedbackString += "<strong style='color: green;'><li>Passed: </strong><strong>" + j + "</strong> - Well done.</li>";  
}