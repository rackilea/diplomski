public static String printGrid(HashMap<Coord, Integer> map) {

int width = 10;
int height = 10;

int lenght = height * width ;

StringBuilder grid = new StringBuilder(lenght);     

// Initialize the builder
int i = 0 ;
  while(i<lenght){
    if(i >= width && i%(width)==0){
            grid.append('\n');
    }
   grid.append('#');        
  i++;
 }

for(Coord c : map.keySet()){
    int index = c.x *(width + 1) + c.y;
      grid.setCharAt(index, map.get(c).toString().charAt(0));
}

 return grid.toString();        
}