create or replace
type body JAggrFunPackageType  is
  static function ODCIAggregateInitialize(sctx IN OUT NOCOPY JAggrFunPackageType)
  return number
  is
  begin
    sctx := JAggrFunPackageType( null );
    return ODCIConst.Success;
  end;

  member function ODCIAggregateIterate(self IN OUT NOCOPY JAggrFunPackageType,
                                       value IN varchar2 )
  return number
  is
     status  NUMBER;
  begin
    if self.jctx is null then

      status := JAggrFunPackage.ODCIInitialize(self.jctx);
      if (status <> ODCIConst.Success) then
         return status;
      end if;
    end if;

    status := JAggrFunPackage.ODCIIterate(jctx,value);

    return status;
  end;

  member function ODCIAggregateTerminate(self IN JAggrFunPackageType,
                                         returnValue OUT NOCOPY VARCHAR2,
                                         flags IN number)
  return number
  is
  begin

    return JAggrFunPackage.ODCITerminate(jctx, returnValue);
  end;

  member function  ODCIAggregateMerge(self IN OUT NOCOPY JAggrFunPackageType,
                           ctx IN JAggrFunPackageType)
  return number
  is
  begin
    return ODCIConst.Success;
  end;
end;
/