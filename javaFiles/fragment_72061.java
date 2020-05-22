import groovy.json.*

def jsonString = '{"parent":{"child":"oldValue"}}'
def newValue = 'newValue'
def stringPath = 'parent.child'

def json = new JsonSlurper().parseText(jsonString)
def jsonbuilder = new JsonBuilder(json)

Eval.xy(jsonbuilder, newValue, 'x.content.' + stringPath + '= y')

System.out.println(jsonbuilder.toString()=='{"parent":{"child":"newValue"}}')
System.out.println(jsonbuilder.content.parent.child == 'newValue')​​​​​​​