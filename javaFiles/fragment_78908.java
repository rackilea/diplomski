package days

import java.lang.IllegalArgumentException


class DaysFactory {
    fun dayFromInt(index: Int): Day {
        return when (index) {
            0 -> Day.Sunday
            1 -> Day.Monday
            2 -> Day.Tuesday
            3 -> Day.Wednesday
            4 -> Day.Thursday
            5 -> Day.Friday
            6 -> Day.Saturday
            else -> throw IllegalArgumentException("illigal index :$index")
        }
    }

    enum class Day(val index: Int) {
        Sunday(0), Monday(1), Tuesday(2), Wednesday(3), Thursday(4), Friday(5), Saturday(6)
    }
}


class DaysRange(val seed: String) {

    var stringFormat = ""

    private fun getTomorrow(dayIndex: Int): Int {
        if (dayIndex != 6) return dayIndex + 1
        return 0
    }

    override fun toString(): String =stringFormat


    init {
        if (isValidInput(seed)) {
            val dayFactory = DaysFactory()
            val indexes = seed.split(",").map { it.toInt() }
            val days = indexes.map { dayFactory.dayFromInt(it) }
            val ranges = splitIndexesToRanges(indexes)
            ranges.forEach { range ->
                if (range.size > 2) {
                    stringFormat += "${dayFactory.dayFromInt(range.first())} to ${dayFactory.dayFromInt(range.last())},"
                } else
                    range.forEach {
                        stringFormat += "${dayFactory.dayFromInt(it)},"
                    }
            }
            stringFormat = stringFormat.dropLast(1)
        }
    }

    private fun splitIndexesToRanges(daysRange: List<Int>): ArrayList<List<Int>> {
        val result = ArrayList<List<Int>>()
        val slicePoint = ArrayList<Int>()
        for (i in 0 until daysRange.size - 1) {
            if (getTomorrow(daysRange[i]) != daysRange[i + 1]) {
                slicePoint.add(i)
            }
        }

        var start = 0
        slicePoint.forEach {
            result.add(daysRange.slice(start..it))
            start = it + 1
        }
        result.add(daysRange.slice(start until daysRange.size))
        return result

    }

}

private fun isValidInput(seed: String): Boolean = true


fun main(args: Array<String>) {

    val input = listOf(
        "0,1,2,4,5,6",
        "5,6,0",
        "1,2,3,4"
    )

    input.forEach {
        val dr = DaysRange(it)
        println(dr)
    }
}