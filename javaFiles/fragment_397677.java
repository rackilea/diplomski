private val PREFERENCES_STUB_2 = kotlin("""
    |package com.example.package
    |
    |class Prefs {
    |
    |    fun putBoolean(key: String, value: Boolean) {}
    |    
    |    fun doWrongs() {
    |
    |        Prefs().putBoolean("abc", true)
    |    }
    |}""".trimMargin())