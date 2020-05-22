BreedData breedData;
DogBreed dogBreed;
String breedCode;
String breedId;
if( animalData != null
&&  (breedData = animalData.getBreedData())!=null
&&  (dogBreed = dogx.getBreed()) != null
&&  (breedCode = dogx.getBreed().getBreedCode()) != null
&&  (breedId = breedData.get(breedCode)) != null
) {
    dogBreed.setBreedId(breedId);
}