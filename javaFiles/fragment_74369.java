(l, r) -> {
      r.forEach((k, v) -> l.merge(k, v,
                    (bi, bii) -> new Genuineness(bi.getTotal() + bii.getTotal(),
                               bi.getTotalGenuine() + bii.getTotalGenuine(),
                               bi.getTotalDevelopment() + bii.getTotalGenuine())));
       return l;
}