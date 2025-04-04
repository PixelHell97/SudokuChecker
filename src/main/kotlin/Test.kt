package org.example

fun main() {
    test(
        name = "Case 1 :- When given a board with " +
                "a blank cells in any board size" +
                " it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf(),
                listOf(),
                listOf(),
                listOf(),
                listOf(),
                listOf(),
                listOf(),
                listOf(),
                listOf(),
            ),
            // boardSize = 9
        ),
        correctAnswer = false,
    )

    test(
        name = "Case 2 :- When given a completed sudoku board" +
                " with non duplicated numbers in the same row, column or box" +
                " in any board size it should return true",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf(8, 9, 4, 3, 6, 1, 2, 5, 7),
                listOf(6, 7, 1, 4, 5, 2, 8, 3, 9),
                listOf(5, 2, 3, 7, 9, 8, 1, 6, 4),
                listOf(4, 8, 7, 6, 3, 5, 9, 2, 1),
                listOf(9, 1, 6, 8, 2, 7, 3, 4, 5),
                listOf(3, 5, 2, 9, 1, 4, 6, 7, 8),
                listOf(1, 3, 9, 5, 7, 6, 4, 8, 2),
                listOf(7, 6, 8, 2, 4, 9, 5, 1, 3),
                listOf(2, 4, 5, 1, 8, 3, 7, 9, 6),
            ),
            // boardSize = 9
        ),
        correctAnswer = true,
    )

    test(
        name = "Case 3 :- When given a sudoku board with duplicated numbers in the same row or column" +
                " in any board size, it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf(1, 2, 3, 4),
                listOf(2, 3, 4, 1),
                listOf(3, 4, 1, 2),
                listOf(4, 1, 2, 2),  // Duplicate '2' in the last row (row violation)
            ),
            // boardSize = 4
        ),
        correctAnswer = false,
    )

    test(
        name = "Case 4 :- When given a sudoku board" +
                " with duplicated numbers in the same 3x3 subgrid in 9x9 board size" +
                " it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf(8, 9, 4, 3, 6, 1, 2, 5, 7),
                listOf(6, 7, 1, 4, 5, 2, 8, 3, 9),
                listOf(5, 2, 3, 7, 9, 8, 1, 6, 4),
                listOf(4, 8, 7, 6, 3, 5, 9, 2, 1),
                listOf(9, 1, 6, 8, 2, 7, 3, 4, 5),
                listOf(3, 5, 2, 9, 1, 4, 6, 7, 8),
                listOf(1, 3, 9, 5, 7, 6, 4, 8, 2),
                listOf(7, 6, 8, 2, 4, 9, 5, 1, 3),
                listOf(2, 4, 5, 1, 8, 3, 7, 9, 5), // '5' is duplicated in the bottom-left subgrid
            ),
            // boardSize = 9
        ),
        correctAnswer = false,
    )

    test(
        name = "Case 5 :- When given a sudoku board" +
                " with empty inputs (witch cell contains - ) in any board size" +
                " it should return true",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf('-'.code, '-'.code, '-'.code, '-'.code),
                listOf('-'.code, '-'.code, '-'.code, '-'.code),
                listOf('-'.code, '-'.code, '-'.code, '-'.code),
                listOf('-'.code, '-'.code, '-'.code, '-'.code),
            ),
            // boardSize = 4
        ),
        correctAnswer = true,
    )

    test(
        name = "Case 6 :- When given a sudoku board with not completed cells but with non-duplicated numbers" +
                " in the same row, column, or subgrid, and empty cells containing ('-') in any board size," +
                " it should return true",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf(8, 9, 4, '-'.code, 6, 1, 2, 5, 7),
                listOf(6, '-'.code, 1, 4, 5, 2, 8, 3, 9),
                listOf(5, 2, '-'.code, 7, 9, 8, 1, 6, 4),
                listOf(4, 8, 7, 6, '-'.code, 5, 9, 2, 1),
                listOf(9, 1, 6, 8, 2, '-'.code, 3, 4, 5),
                listOf(3, 5, 2, 9, 1, 4, '-'.code, 7, 8),
                listOf(1, 3, 9, 5, 7, 6, 4, '-'.code, 2),
                listOf(7, 6, 8, 2, 4, 9, 5, 1, '-'.code),
                listOf('-'.code, 4, 5, 1, 8, 3, 7, 9, 6),
            ),
            // boardSize = 9
        ),
        correctAnswer = true,
    )

    test(
        name = "Case 7 :- In case board size is 9, When given a board that contains numbers out of range (1-9)," +
                " it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf(8, 9, 4, 3, 6, 1, 2, 5, 7),
                listOf(6, 7, 1, 4, 5, 2, 8, 3, 9),
                listOf(5, 2, 3, 7, 9, 8, 1, 6, 4),
                listOf(4, 8, 7, 6, 3, 5, 9, 2, 1),
                listOf(9, 1, 6, 8, 2, 7, 3, 4, 5),
                listOf(3, 5, 2, 9, 1, 4, 6, 7, 8),
                listOf(1, 3, 9, 5, 7, 6, 4, 8, 2),
                listOf(7, 6, 8, 2, 4, 9, 5, 1, 3),
                listOf(2, 4, 5, 1, 8, 10, 7, 9, 6), // '10' is out of range (should be between 1-9)
            ),
            // boardSize = 9
        ),
        correctAnswer = false,
    )

    test(
        name = "Case 9 :- In case board size is 4, When given a board that contains numbers out of range (1-4)," +
                " it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf(1, 2, 3, 4),
                listOf(2, 3, 4, 1),
                listOf(3, 4, 1, 5), // '5' is out of range (should be between 1-4)
                listOf(4, 1, 2, 3),
            ),
            // boardSize = 4
        ),
        correctAnswer = false,
    )

    test(
        name = "Case 10 :- In case board size is 16, When given a board that contains numbers out of range (1-16)," +
                " it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16),
                listOf(5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 1, 2, 3, 4),
                listOf(9, 10, 11, 12, 13, 14, 15, 16, 1, 2, 3, 4, 5, 6, 7, 8),
                listOf(13, 14, 15, 16, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 17), // '17' is out of range (1-16)
                listOf(2, 3, 4, 1, 6, 7, 8, 5, 10, 11, 12, 9, 14, 15, 16, 13),
                listOf(6, 7, 8, 5, 10, 11, 12, 9, 14, 15, 16, 13, 2, 3, 4, 1),
                listOf(10, 11, 12, 9, 14, 15, 16, 13, 2, 3, 4, 1, 6, 7, 8, 5),
                listOf(14, 15, 16, 13, 2, 3, 4, 1, 6, 7, 8, 5, 10, 11, 12, 9),
                listOf(3, 4, 1, 2, 7, 8, 5, 6, 11, 12, 9, 10, 15, 16, 13, 14),
                listOf(7, 8, 5, 6, 11, 12, 9, 10, 15, 16, 13, 14, 3, 4, 1, 2),
                listOf(11, 12, 9, 10, 15, 16, 13, 14, 3, 4, 1, 2, 7, 8, 5, 6),
                listOf(15, 16, 13, 14, 3, 4, 1, 2, 7, 8, 5, 6, 11, 12, 9, 10),
                listOf(4, 1, 2, 3, 8, 5, 6, 7, 12, 9, 10, 11, 16, 13, 14, 15),
                listOf(8, 5, 6, 7, 12, 9, 10, 11, 16, 13, 14, 15, 4, 1, 2, 3),
                listOf(12, 9, 10, 11, 16, 13, 14, 15, 4, 1, 2, 3, 8, 5, 6, 7),
                listOf(16, 13, 14, 15, 4, 1, 2, 3, 8, 5, 6, 7, 12, 9, 10, 11),
            ),
            // boardSize = 16
        ),
        correctAnswer = false,
    )


    test(
        name = "Case 11 :- When passing board size of 4 and given the board as 9x9" +
                " it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf(1, 9, 4, 3, 6, 9, 2, 5, 7),
                listOf(6, 7, 1, 4, 5, 2, 8, 3, 9),
                listOf(5, 2, 3, 7, 9, 8, 1, 6, 4),
                listOf(4, 8, 7, 6, 3, 5, 9, 2, 1),
                listOf(9, 1, 6, 8, 2, 7, 3, 4, 5),
                listOf(3, 5, 2, 9, 1, 4, 6, 7, 8),
                listOf(1, 3, 9, 5, 7, 6, 4, 8, 2),
                listOf(7, 6, 8, 2, 4, 9, 5, 1, 3),
                listOf(2, 4, 5, 1, 8, 3, 7, 9, 6),
            ),
            // boardSize = 4
        ),
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
