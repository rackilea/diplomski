public class Schematic{

 public List<Location> pasteSchematic(File f){  
  try{
   FileInputStream fis = new FileInputStream(f);
   NBTTagCompound nbt = NBTCompressedStreamTools.a(fis);

   short width = nbt.getShort("Width");
   short height = nbt.getShort("Height");
   short length = nbt.getShort("Length");

   byte[] blocks = nbt.getByteArray("Blocks");
   byte[] data = nbt.getByteArray("Data");

   fis.close();


   List<Location> locations = new ArrayList<Location>();
   //paste
   for(int x = 0; x < this.width; ++x){
    for(int y = 0; y < this.height; ++y){
     for(int z = 0; z < this.length; ++z){
      int index = y * this.width * this.length + z * this.width + x;
      final Location l = new Location(loc.getWorld(), x + loc.getX(), y + loc.getY(), z + loc.getZ());
      int b = this.blocks[index] & 0xFF;//make the block unsigned, so that blocks with an id over 127, like quartz and emerald, can be pasted
      final Block block = l.getBlock();
      block.setType(Material.getMaterial(b));
      block.setData(this.data[index]);

      Material m = Material.getMaterial(b);
      //you can check what type the block is here, like if(m.equals(Material.BEACON)) to check if it's a beacon        

      locations.add(l);
     }
    }
   }
  }
  catch(Exception e){e.printStackTrace();}
 }
 return locations;
}