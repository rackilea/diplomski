Map model=[:]

List names=['Tim','Greg','Bob']

names?.each { name->
  //dynamically call something that returns a list
 //  model."${name}"= getSomeList(name)


//get a list assign it the above list maybe something like this
//   List someTasks = ['task1','task2'] 
//   model."${name}"=  someTasks
//or shorter
//    model."${name}"=  ['task1','task2'] 

// 1 element multi element list
    if (name=='Bob') {
      model."${name}"=  ['task1']
    } else {
      model."${name}"=  ['task1','task2'] 
    }
}

//This iterates through map and its value being another iteration
model?.each{ key,value ->
  println "working on $key" 
   value?.each { v-
     println "$key has task ${v}"
    }
}