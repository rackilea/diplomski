PrintStream ps = new PrintStream(fos);
final Analysis analysis = new Analysis();
stream.forEach(line - > {
    ps.println("Code: " + analysis.parse(line).getCode()); 
    score[0] = score[0] + analysis.parse(line).getCode(); 
}