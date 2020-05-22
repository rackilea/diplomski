try  { (FileWriter writer = new FileWriter("filename.txt");
 BufferedWriter bw = new BufferedWriter(writer)) 

for (/*main loop*/){
   bw.write(string);
   for (/*several sub loops*/){
    bw.write(/*more strings*/);
    }
for (/*several sub loops*/){
    bw.write(/*more strings*/);
    }
   }

bw.write(/*final string*/);


bw.close(); 


} catch (IOException e) {
   System.out.println("error");
}