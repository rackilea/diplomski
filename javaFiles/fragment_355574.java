fun upgradeFromV0() {}
fun upgradeFromV1() {}
fun upgradeFromV2() {}
fun upgradeFromV3() {}

val upgrades = arrayOf(::upgradeFromV0, ::upgradeFromV1, ::upgradeFromV2, ::upgradeFromV3)

fun upgradeFrom(oldVersion: Int) {
    for (i in oldVersion..upgrades.lastIndex) {
        upgrades[i]()
    }
}