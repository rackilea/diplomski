project-root
|-- module1 - apply plugin: 'jar'
|-- module2 - apply plugin: 'jar'
|-- module3 - apply plugin: 'jar'
|-- module4 - apply plugin: 'jar'
|-- newModule (newly added!)
|   |-- sub1
|   |-- sub2
|-- war1  - apply plugin: 'war'
|   dependencies {
|     compile project(':module1')
|     compile project(':module2')
|   }
|-- war2  - apply plugin: 'war'
|   dependencies {
|     compile project(':module3')
|     compile project(':module4')
|   }