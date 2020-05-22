@Benchmark
public int directCompleteInc() {
    int result = 0;
    for (int i = 0; i < 1000; i++) {
        switch (getValue()) {
            case 1:
                result++;
                break;
            default:
                break;
        }
    }
    return result;
}