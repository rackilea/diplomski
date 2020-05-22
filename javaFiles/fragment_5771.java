//CREATE
CREATE (:User {username: 'goofy1'}), (:User {username: 'goofy2'})
, (:Tweet {tweet_user_mention: ['goofy0', 'goofy1']})

//MATCH all tweets and make sure they have relationships to the users they mention
MATCH (t:Tweet)
FOREACH (user_mentioned IN (t.tweet_user_mention) | 
    MERGE (mentioned:User {username:user_mentioned})
    MERGE t-[:MENTIONS]->mentioned
)

//MATCH tweets mentioning specific username and merge the relationship to that user
MATCH (t:Tweet)
WHERE 'goofy0' IN t.tweet_user_mention
MERGE (u:User {username: 'goofy0'})
MERGE t-[:MENTIONS]->u