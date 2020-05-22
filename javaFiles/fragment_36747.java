.method public hidebysig static void Main() cil managed
{
    .entrypoint
    .maxstack 8
    L_0000: call int32 Test::Foo()
    L_0005: pop 
    L_0006: call int32 Test::Foo()
    L_000b: pop 
    L_000c: ret 
}