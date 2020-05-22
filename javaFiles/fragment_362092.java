public StringBuilder getProductName() {

    StringBuilder sb = new StringBuilder(productName);
    try {
        return sb;
    }
    finally {
        sb.append("Modified");
    }
}