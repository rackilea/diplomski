EleveBean  *eleveBean = [EleveBean new];
eleveBean.nom = @"bob";
eleveBean.prenom = @"john";
tns1_EleveBean *tnsEleve = [tns1_EleveBean new];

[BeanUtils copyProperties:eleveBean dest:tnsEleve];
STAssertEquals(eleveBean.nom, tnsEleve.nom, @"");
STAssertEquals(eleveBean.prenom, tnsEleve.prenom, @"");