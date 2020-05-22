result = filter(lines, bufferedReader.readLine());
if(!result[0].equals("emp")) {
    System.out.println("x: " + result[0] + " " + "y: " + result[1]);
    System.out.println(MainActivity.analysisKeyPress.classify(Integer.valueOf(result[0]), Integer.valueOf(result[1]), "0"));
    System.out.println("insert into db..");
    MainActivity.dbhelper.addKeyLog(getCurrentRunningService(), result[0], result[1]);
}