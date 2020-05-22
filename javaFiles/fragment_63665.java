with Par_Pkg; use Par_Pkg;
procedure Par_Main is
   Par_Obj : Par_Class_Ptr;
   Int_Obj : Integer_Ptr;
begin
   Int_Obj := new Integer;
   Int_Obj.all := 12; -- don t worry about been string or integer
   Par_Obj := Par_Obj.Construct 
     (aValue => 23,
      aName => Int_Obj);
end Par_Main;