package com.ba

import kotlin.reflect.KClass

abstract class IDatabase<T> { }

open class Database2<T: Any>(val tClass: KClass<T>) : IDatabase<T>() {
  // just wrap a `object` to confort the user
  companion object {
    inline fun <reified T: Any> getInstance(): Database2<T> = Database2(T::class)
  }
}

fun main(args: Array<String>) {
  val databaseString = Database2.getInstance<String>()
  println(databaseString.tClass)

  val databaseInt = Database2.getInstance<Int>()
  println(databaseInt.tClass)
}