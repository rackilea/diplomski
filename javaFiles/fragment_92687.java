//'WordnetPOS' is an instance of the class POS defined in JWNL. It indicates the part of        
//speech tag. token
JWNL.initialize(new FileInputStream("path/file_properties.xml"));
Dictionary wordnet = Dictionary.getInstance();
IndexWord token = wordnet.lookupIndexWord(WordnetPos, word); //word is a string
Synset[] senses = token.getSenses();
String Dom = new String();

for (int i = 0; i < senses.length; i++) {
   String domSet = new String();
   try {

   //CATEGORY is the pointer type of the synset containing the domains

   Pointer[] pointerArr = senses[i].getPointers(PointerType.CATEGORY);
   for (Pointer pointer : pointerArr) {
       Synset syn = pointer.getTargetSynset();
       Word[] words = syn.getWords();
       for (Word word : words) {
           domaSet = domaSet + word.getLemma().trim().toLowerCase() + " ";
       }
   }
   catch (NullPointerException e) {
   }
   Dom = Dom + domSet;
}