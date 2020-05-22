// your code
...
    }
    i++;
}

for (i = 0; i < resultQueue.size() - 1; i++) {
    if ("-".equals(resultQueue.get(i)) && "-".equals(resultQueue.get(i+1))) {
        resultQueue.set(i, "+");
    }
}

// your code
for (String r : resultQueue) {
    if (r.charAt(0) > '0' && r.charAt(0) < '9') {
...