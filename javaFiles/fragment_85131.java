package com.stackoverflow.reversefile

import java.io.File
import java.util.*

fun main(args: Array<String>) {
    val maxBufferSize = 50000
    val lineBuffer = ArrayList<String>(maxBufferSize)
    val tempFiles = ArrayList<File>()
    val originalFile = File("/data/wikidata/20150629.json")
    val tempFilePrefix = "/data/wikidata/temp/temp"
    val maxLines = 10000000

    var approxCharCount: Long = 0
    var tempFileCount = 0
    var lineCount = 0

    val startTime = System.currentTimeMillis()

    println("Writing reversed partial files...")

    try {
        fun flush() {
            val bufferSize = lineBuffer.size
            if (bufferSize > 0) {
                lineCount += bufferSize
                tempFileCount++
                File("$tempFilePrefix-$tempFileCount").apply {
                    bufferedWriter().use { writer ->
                        ((bufferSize - 1) downTo 0).forEach { idx ->
                            writer.write(lineBuffer[idx])
                            writer.newLine()
                        }
                    }
                    tempFiles.add(this)
                }
                lineBuffer.clear()
            }

            println("  flushed at $lineCount lines")
        }

        // read and break into backword sorted chunks
        originalFile.bufferedReader(bufferSize = 4096 * 32)
                .lineSequence()
                .takeWhile { lineCount <= maxLines }.forEach { line ->
                    lineBuffer.add(line)
                    if (lineBuffer.size >= maxBufferSize) flush()
                }
        flush()

        // read backword sorted chunks backwards
        println("Reading reversed lines ...")
        tempFiles.reversed().forEach { tempFile ->
            tempFile.bufferedReader(bufferSize = 4096 * 32).lineSequence()
                .forEach { line ->
                    approxCharCount += line.length
                    // a line has been read here
                }
            println("  file $tempFile current char total $approxCharCount")
        }
    } finally {
        tempFiles.forEach { it.delete() }
    }

    val elapsed =  System.currentTimeMillis() - startTime

    println("temp file count:   $tempFileCount")
    println("approx char count: $approxCharCount")
    println("total line count:  $lineCount")
    println()
    println("Elapsed:  ${elapsed}ms  ${elapsed / 1000}secs  ${elapsed / 1000 / 60}min  ")

    println("reading original file again:")
    val againStartTime = System.currentTimeMillis()
    var againLineCount = 0
    originalFile.bufferedReader(bufferSize = 4096 * 32)
            .lineSequence()
            .takeWhile { againLineCount <= maxLines }
            .forEach { againLineCount++ }
    val againElapsed =  System.currentTimeMillis() - againStartTime
    println("Elapsed:  ${againElapsed}ms  ${againElapsed / 1000}secs  ${againElapsed / 1000 / 60}min  ")
}