jGenerator.writeStartObject(); // {

jGenerator.writeObjectFieldStart("head"); // {"head": {
jGenerator.writeStringField("label", "head"); // {"head": {"label":"head"

jGenerator.writeObjectFieldStart("data"); // {"head": {"label":"head", "data": {

// you're in the context of an object, so a name is expected, it will be empty when written
jGenerator.writeStartArray(); // {"head": {"label":"head", "data": {:[
jGenerator.writeStartObject(); // {"head": {"label":"head", "data": {:[{
// again, you're in the context of an object, so a name is expected
jGenerator.writeNumber(2001); // {"head": {"label":"head", "data": {:[{:2001