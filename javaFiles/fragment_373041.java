abstract class MyScript extends Script {
    def methodMissing(String name, args) {
        // this will call any method called inside the script
        // on the sample Object
        binding.sampleObject."$name"(*args)
    }
}