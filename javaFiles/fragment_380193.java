public class RealmMigration implements io.realm.RealmMigration {

.

.

.

        if (oldVersion == 3) {
            //Create a schema for Bank
            final RealmObjectSchema bankSchema = realmSchema.get("Bank");
            //Create a schema for Token that has been in Bank model
            final RealmObjectSchema tokenSchema = realmSchema.get("Token");
            //We use bankSchema for add tokenList field and transform
            bankSchema
                .addRealmListField("tokenList", tokenSchema)
                .transform((obj) -> {//obj is bank model,we have a transform in bank model
                         DynamicRealmObject token = obj.get("Token");
                         List<DynamicRealmObject> tokenList = obj.get("tokenList");
                                //We add token from pre version to tokenList in new version
                                if (token != null) tokenList.add(token);
                            }
                    )
                    //Finally remove unwanted field
                    .removeField("Token");
        }
}