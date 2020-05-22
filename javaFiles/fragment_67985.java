if (originalAmount.contains("$")) {
        originalAmount = originalAmount.replace("$", "");
    }

    newOriginalAmt = Double.parseDouble(originalAmount);
    System.out.println(newOriginalAmt);