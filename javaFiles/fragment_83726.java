// Returns a representation in the "text/xml" media type
@Get("xml")
String toString();

// Stores representations in the "text/xml" media type 
// after conversion to a DOM document
@Put("xml")
void store(Document doc)

// Stores representations in the "text/xml" media type after
// conversion to a DOM document and returns a plain text response
@Put("xml:txt")
String store(Document doc)

// Returns a representation in the "text/xml" media type with 
// an inlining depth level of 2
@Get("xml?depth=2")

// Alternative variants
@Put("xml|json:json")

// Alternative variants
@Put("xml+ascii | json+utf8 : json")