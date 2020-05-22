{
  "@context":
  {
    "name": "http://schema.org/name",  // ← This means that 'name' is shorthand for 'http://schema.org/name' 
    "image": {
      "@id": "http://schema.org/image",  // ← This means that 'image' is shorthand for 'http://schema.org/image' 
      "@type": "@id"  // ← This means that a string value associated with 'image' should be interpreted as an identifier that is an IRI 
    },
    "homepage": {
      "@id": "http://schema.org/url",  // ← This means that 'homepage' is shorthand for 'http://schema.org/url' 
      "@type": "@id"  // ← This means that a string value associated with 'homepage' should be interpreted as an identifier that is an IRI 
    }
  }
}