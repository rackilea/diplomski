@PostRemove
public void removeTranslationByAttribute(Attribute attribute){

List<Attribute> attributes = AttributeRepository.getByNameTranslationId(attribute.getNameTranslation()); //get all atribute by `name_translation_id`

if(attributes.size() == 0) // when not include atrribute in list`name_translation_id`
TranslationRepository.deleteById(attribute.getNameTranslation()); // delete translation object by `name_translation_id`

}