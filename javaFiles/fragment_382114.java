{
  "beans": [
    {
      "baseField": "base",
      "@type": "BaseBean"
    },
    {
      "childField": "child",
      "baseField": "base",
      "@type": "ChildBean"
    },
    {
      "bean2Int": 356,
      "baseField": "base",
      "@type": "ChildBean2"
    }
  ]
}
BaseBean{baseField='base'}
ChildBean{baseField='base', childField='child'}
ChildBean2{baseField='base', bean2Int=356}