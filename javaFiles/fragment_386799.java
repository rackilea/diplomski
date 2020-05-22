Process proceso = Runtime.getRuntime().exec("java -jar C:\\Users\\Cristian\\Desktop\\java\\numeros.jar");
BufferedWriter out = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));
BufferedReader in = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
String texto;

out.write(entrada + "\n");
out.flush();

while((texto = in.readLine()) !=null){
    ...