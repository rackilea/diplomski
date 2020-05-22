public static void main(final String[] argsWithNum) {
    int numberOfSimultaneousExecutions = Integer.parseInt(argsWithNum[0]);
    final String[] args = new String[argsWithNum.length - 1];
    System.arraycopy(argsWithNum, 1, args, 0, args.length);
    java.util.concurrent.Executor executor = java.util.concurrent.Executors.newFixedThreadPool(numberOfSimultaneousExecutions);
    ...