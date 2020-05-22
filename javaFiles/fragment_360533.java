String prg = "import sys";
BufferedWriter out = new BufferedWriter(new FileWriter("path/a.py"));
out.write(prg);
out.close();
Process p = Runtime.getRuntime().exec("python path/a.py");
BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
String ret = in.readLine();
System.out.println("value is : "+ret);