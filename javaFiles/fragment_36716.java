public RegionLabel(List<String> list) throws Exception{
     if( null == list || list.size() < 3 )
          throw new Exception("illegal parameter");
     this.centre = list.get(0);
      ...
}