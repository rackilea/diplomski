if (temp.retrieveAt(i+r) == null) {
    currentValue = productCoeff;
} else {
    currentValue = (temp.retrieveAt(i+r));
}

currentValue = currentValue.addComplex(productCoeff);