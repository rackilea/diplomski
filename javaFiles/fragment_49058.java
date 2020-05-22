Gson 2.1 introduced a new TypeAdapter interface that permits mixed tree and streaming
serialization and deserialization.

The API is efficient and flexible. See Gson's Streaming doc for an example of combining 
tree and binding modes. This is strictly better than mixed streaming and tree modes; with
binding you don't waste memory building an intermediate representation of your values.

Gson has APIs to recursively skip an unwanted value; Gson calls this skipValue().