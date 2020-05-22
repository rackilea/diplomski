dn: cn=module{0}, cn=config
changetype: modify
add: olcModuleLoad
olcModuleLoad: sssvlv.la

dn: olcOverlay=sssvlv,olcDatabase={1}hdb,cn=config
changetype: add
objectClass: olcSssVlvConfig
olcSssVlvMax: 10
olcSssVlvMaxKeys: 5