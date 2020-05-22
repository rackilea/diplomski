let cla = NSClassFromString(className)
if let cla = cla as? NSObject.Type {
    let selector: Selector = NSSelectorFromString(methodName)
    let instance = cla.init()
    if (instance.responds(to: selector)) {
        print(instance.perform(selector))
    } else {
        print("method not found")
    }
} else {
    print("class not found")
}