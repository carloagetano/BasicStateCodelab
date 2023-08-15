package com.example.basicstatecodelab

/**
 * Longest word:
 * find the longest word in a given string.
 * Example: longestWord(“big flower”) = flower
 * longestWord("this is a house") = house
 * longestWord("InterviewDOT keep sharing") = InterviewDOT
 */
fun main() {
    println(longestWord("big flower"))
    println(longestWord("this is a house"))
    println(longestWord("InterviewDOT keep sharing"))
}

private fun longestWord(inputString: String): String? {
    return inputString.split(" ").maxByOrNull { it.length }
}