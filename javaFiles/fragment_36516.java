Dancer findUnpartnered(List<Dancer> list) {
   for (Dancer d : list) {
      if (d.isUnpartnered()) {
          return d;
      }
   }
   return null;
}