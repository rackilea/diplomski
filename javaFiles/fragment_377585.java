expect(mockDaoTSiIdabareme.findByDate(isA(Date.class)))
         .andAnswer(new IAnswer<Collection<T_SI_IDABAREME>>() {
              public Collection<T_SI_IDABAREME> answer() throws Throwable {
                  return searchByParameter((Date)getCurrentArguments()[0]);
              } 
         }
);