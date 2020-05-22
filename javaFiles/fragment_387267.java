System.out.print("Enter song index location: ");
int searchIndex = input.nextInt();
if (searchIndex >= 0 && searchIndex < list.size(){ 
   System.out.println(list.get(searchIndex).getValue());
}
else{
    System.out.println("Song does not exist.");
}