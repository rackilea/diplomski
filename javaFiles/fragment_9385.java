@Produces
@Preferred
private static  Hello getHello(@New HelloBanned ban,
                      @New HelloCoolGuy cool, Usuario usuario){
    if (usuario.isBannedFlag()){
       return ban;
    }
    return cool;
}