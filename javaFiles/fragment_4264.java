enum Age {
  ELEVEN_TO_TWENTY,
  TWENTYONE_TO_FORTY
};

Age age; 
if(between(11, years, 20)) {
   age = Age.ELEVEN_TO_TWENTY;
}
if(between(21, years, 40)) {
   age = Age.TWENTYONE_TO_FORTY;
}