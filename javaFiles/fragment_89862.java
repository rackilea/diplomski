PrintWriter pw = new PrintWriter(new FileWriter("fileName"),true);
pw.println("[");
for(int i=0;i<pred.length;i++)
{
pw.println(pred[i]+" ");
}
pw.println("]");
pw.close();