input: { "string-property": "string-value", "int-property": 1, "bool-property": true, "collection-property": ["a", "b", "c"], "map-property": {"inner-property": "inner-value"} }
output:
key: string-property
value type: class java.lang.String
value: string-value
key: int-property
value type: class java.lang.Integer
value: 1
key: bool-property
value type: class java.lang.Boolean
value: true
key: collection-property
value type: class java.util.ArrayList
value: [a, b, c]
key: map-property
value type: class java.util.LinkedHashMap
value: {inner-property=inner-value}