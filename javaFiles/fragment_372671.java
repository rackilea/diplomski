interface Encrypt{
   //          v--- don't include the infrastructure class here,e.g:`Keys`,`Cipher`
   fun encode(...args)
}

interface Decrypt{
   //          v--- don't include the infrastructure class here,e.g:`Keys`,`Cipher`
   fun decode(...args)
}