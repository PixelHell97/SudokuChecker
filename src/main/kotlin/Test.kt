package org.example

fun main() {

}

fun test(
    name: String,
    result: Boolean,
    correctAnswer: Boolean,
) {
    if (correctAnswer == result) {
        println("Success - $name")
    } else {
        println("Failed - $name")
    }
}
