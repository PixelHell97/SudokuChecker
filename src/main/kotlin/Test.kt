package org.example

fun main() {
    test(
        name = "When given an empty sudoku board it should return true",
        result = isValidSudokuBoard(""),
        correctAnswer = true,
    )

    test(
        name = "When given a valid sudoku board it should return true",
        result = isValidSudokuBoard(""),
        correctAnswer = true,
    )

    test(
        name = """
            When given a sudoku board that contains 
            anything instead of number or (-) in one of 
            it's houses it should return false
            """.trimIndent(),
        result = isValidSudokuBoard(""),
        correctAnswer = false,
    )

    test(
        name = """
            When given a sudoku board that contains 
            a duplicated number in the same row or column 
            it should return false
            """.trimIndent(),
        result = isValidSudokuBoard(""),
        correctAnswer = false,
    )

    test(
        name = "When given a sudoku board that contains a duplicated number in the same box it should return false",
        result = isValidSudokuBoard(""),
        correctAnswer = false,
    )

    test(
        name = """
            When given a sudoku board that contains 
            a number smaller than 1 and bigger than 9 in one of it's houses 
            it should return false
            """.trimMargin(),
        result = isValidSudokuBoard(""),
        correctAnswer = false,
    )
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
