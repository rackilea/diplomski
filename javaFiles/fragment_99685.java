CREATE OR REPLACE 
TYPE JAggrFunPackageType authid current_user AS OBJECT
  (  
   jctx NUMBER, -- stored context;  not used in dummy implementation
   STATIC FUNCTION
        ODCIAggregateInitialize(sctx IN OUT NOCOPY JAggrFunPackageType )
        RETURN NUMBER,

   MEMBER FUNCTION
        ODCIAggregateIterate(self IN OUT NOCOPY JAggrFunPackageType,
                             VALUE IN VARCHAR2 )
        RETURN NUMBER,

   MEMBER FUNCTION
        ODCIAggregateTerminate(self IN JAggrFunPackageType,
                               returnValue OUT NOCOPY VARCHAR2,
                               flags IN NUMBER)
        RETURN NUMBER, 

   MEMBER FUNCTION
        ODCIAggregateMerge(self IN OUT NOCOPY JAggrFunPackageType,
                           ctx IN JAggrFunPackageType)
        RETURN NUMBER
);
/