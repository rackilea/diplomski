model << ['Greg':[ 
                'task1' :  ['do thing1','do thing2'], 
                'task2': [ 'do xyz', 'do abc'] 
               ]
          ]

//This iterates through map and its value being another map with an iteration
model?.each{ key,value ->
  println "working on $key" 
   value?.each {k, v->
     println "$key  has task ${k}"
       v?.each { vv ->
          println "$key has task ${k} which needs to do ${vv}"
         }
    }
}