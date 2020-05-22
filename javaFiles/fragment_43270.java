fun main() {
val s: List<Float> = listOf(1.2F, 1.4F, 5.6F) 
// populate it with your custom list data
var sum = 0F

s.forEach { it ->
    sum+=it
}
println("Sum = $sum and avg = ${sum/(s.size)}")

}