String materialName = arg[n]..toUpperCase();
Material theMaterial = null;
try
{
  theMaterial = Material.valueOf(materialName );
}
catch (Exception e)
{
  //Not a valid material
}