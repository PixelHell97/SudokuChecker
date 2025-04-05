package org.example

fun main() {
    test(
        name = "When given a board with " +
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
        ),
        correctAnswer = false,
    )

    test(
        name = "When given a completed sudoku board" +
                " with non duplicated numbers in the same row, column or box" +
                " in any board size it should return true",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf('8', '9', '4', '3', '6', '1', '2', '5', '7'),
                listOf('6', '7', '1', '4', '5', '2', '8', '3', '9'),
                listOf('5', '2', '3', '7', '9', '8', '1', '6', '4'),
                listOf('4', '8', '7', '6', '3', '5', '9', '2', '1'),
                listOf('9', '1', '6', '8', '2', '7', '3', '4', '5'),
                listOf('3', '5', '2', '9', '1', '4', '6', '7', '8'),
                listOf('1', '3', '9', '5', '7', '6', '4', '8', '2'),
                listOf('7', '6', '8', '2', '4', '9', '5', '1', '3'),
                listOf('2', '4', '5', '1', '8', '3', '7', '9', '6'),
            ),
        ),
        correctAnswer = true,
    )

    test(
        name = "When given a sudoku board with duplicated numbers in the same row or column" +
                " in any board size, it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf('1', '2', '3', '4'),
                listOf('2', '3', '4', '1'),
                listOf('3', '4', '1', '2'),
                listOf('4', '1', '2', '2'),  // Duplicate '2' in the last row (row violation)
            ),
        ),
        correctAnswer = false,
    )

    test(
        name = "When given a sudoku board" +
                " with duplicated numbers in the same 3x3 subgrid in 9x9 board size" +
                " it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf('8', '9', '4', '3', '6', '1', '2', '5', '7'),
                listOf('6', '7', '1', '4', '5', '2', '8', '3', '9'),
                listOf('5', '2', '3', '7', '9', '8', '1', '6', '4'),
                listOf('4', '8', '7', '6', '3', '5', '9', '2', '1'),
                listOf('9', '1', '6', '8', '2', '7', '3', '4', '5'),
                listOf('3', '5', '2', '9', '1', '4', '6', '7', '8'),
                listOf('1', '3', '9', '5', '7', '6', '4', '8', '2'),
                listOf('7', '6', '8', '2', '4', '9', '5', '1', '3'),
                listOf('2', '4', '5', '1', '8', '3', '7', '9', '5'), // '5' is duplicated in the bottom-left subgrid
            ),
        ),
        correctAnswer = false,
    )

    test(
        name = "When given a sudoku board" +
                " with empty inputs (witch cell contains - ) in any board size" +
                " it should return true",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf('-', '-', '-', '-'),
                listOf('-', '-', '-', '-'),
                listOf('-', '-', '-', '-'),
                listOf('-', '-', '-', '-'),
            ),
        ),
        correctAnswer = true,
    )

    test(
        name = "When given a sudoku board with not completed cells but with non-duplicated numbers" +
                " in the same row, column, or subgrid, and empty cells containing ('-') in any board size," +
                " it should return true",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf('8', '9', '4', '-', '6', '1', '2', '5', '7'),
                listOf('6', '-', '1', '4', '5', '2', '8', '3', '9'),
                listOf('5', '2', '-', '7', '9', '8', '1', '6', '4'),
                listOf('4', '8', '7', '6', '-', '5', '9', '2', '1'),
                listOf('9', '1', '6', '8', '2', '-', '3', '4', '5'),
                listOf('3', '5', '2', '9', '1', '4', '-', '7', '8'),
                listOf('1', '3', '9', '5', '7', '6', '4', '-', '2'),
                listOf('7', '6', '8', '2', '4', '9', '5', '1', '-'),
                listOf('-', '4', '5', '1', '8', '3', '7', '9', '6'),
            ),
        ),
        correctAnswer = true,
    )

    test(
        name = "When given a board that contains numbers out of range (1-9)" +
                " in case board size is 9" +
                " it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf('8', '9', '4', '3', '6', '1', '2', '5', '7'),
                listOf('6', '7', '1', '4', '5', '2', '8', '3', '9'),
                listOf('5', '2', '3', '7', '9', '8', '1', '6', '4'),
                listOf('4', '8', '7', '6', '3', '5', '9', '2', '1'),
                listOf('9', '1', '6', '8', '2', '7', '3', '4', '5'),
                listOf('3', '5', '2', '9', '1', '4', '6', '7', '8'),
                listOf('1', '3', '9', '5', '7', '6', '4', '8', '2'),
                listOf('7', '6', '8', '2', '4', '9', '5', '1', '3'),
                listOf('2', '4', '5', '1', '8', 'a', '7', '9', '6'), // 'a' is out of range (should be between 1-9)
            ),
        ),
        correctAnswer = false,
    )

    test(
        name = "When given a board that contains numbers out of range (1-4)" +
                " in case board size is 4" +
                " it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf('1', '2', '3', '4'),
                listOf('2', '3', '4', '1'),
                listOf('3', '4', '1', '5'), // '5' is out of range (should be between 1-4)
                listOf('4', '1', '2', '3'),
            ),
        ),
        correctAnswer = false,
    )

    test(
        name = "When given a board that contains numbers out of range (1-16)" +
                " in case board size is 16" +
                " it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g'),
                listOf('5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', '1', '2', '3', '4'),
                listOf('9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', '1', '2', '3', '4', '5', '6', '7', '8'),
                listOf(
                    'd',
                    'e',
                    'f',
                    'g',
                    '1',
                    '2',
                    '3',
                    '4',
                    '5',
                    '6',
                    '7',
                    '8',
                    '9',
                    'a',
                    'b',
                    'h'
                ), // 'h' is out of range (1 to 9) and (A to G)
                listOf('2', '3', '4', '1', '6', '7', '8', '5', 'a', 'b', 'c', '9', 'e', 'f', 'g', 'd'),
                listOf('6', '7', '8', '5', 'a', 'b', 'c', '9', 'e', 'f', 'g', 'd', '2', '3', '4', '1'),
                listOf('a', 'b', 'c', '9', 'e', 'f', 'g', 'd', '2', '3', '4', '1', '6', '7', '8', '5'),
                listOf('e', 'f', 'g', 'd', '2', '3', '4', '1', '6', '7', '8', '5', 'a', 'b', 'c', '9'),
                listOf('3', '4', '1', '2', '7', '8', '5', '6', 'b', 'c', '9', 'a', 'f', 'g', 'd', 'e'),
                listOf('7', '8', '5', '6', 'b', 'c', '9', 'a', 'f', 'g', 'd', 'e', '3', '4', '1', '2'),
                listOf('b', 'c', '9', 'a', 'f', 'g', 'd', 'e', '3', '4', '1', '2', '7', '8', '5', '6'),
                listOf('f', 'g', 'd', 'e', '3', '4', '1', '2', '7', '8', '5', '6', 'b', 'c', '9', 'a'),
                listOf('4', '1', '2', '3', '8', '5', '6', '7', 'c', '9', 'a', 'b', 'g', 'd', 'e', 'f'),
                listOf('8', '5', '6', '7', 'c', '9', 'a', 'b', 'g', 'd', 'e', 'f', '4', '1', '2', '3'),
                listOf('c', '9', 'a', 'b', 'g', 'd', 'e', 'f', '4', '1', '2', '3', '8', '5', '6', '7'),
                listOf('g', 'd', 'e', 'f', '4', '1', '2', '3', '8', '5', '6', '7', 'c', '9', 'a', 'b'),
            ),
        ),
        correctAnswer = false,
    )

    test(
        name = "When given a board that contains numbers out of range (1-16)" +
                " in case board size is 16" +
                " it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf('1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g'),
                listOf('5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', '1', '2', '3', '4'),
                listOf('9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', '1', '2', '3', '4', '5', '6', '7', '8'),
                listOf(
                    'd',
                    'e',
                    'f',
                    'g',
                    '1',
                    '2',
                    '3',
                    '4',
                    '5',
                    '6',
                    '7',
                    '8',
                    '9',
                    'a',
                    'b',
                    'h'
                ), // 'h' is out of range (1 to 9) and (A to G)
                listOf('2', '3', '4', '1', '6', '7', '8', '5', 'a', 'b', 'c', '9', 'e', 'f', 'g', 'd'),
                listOf('6', '7', '8', '5', 'a', 'b', 'c', '9', 'e', 'f', 'g', 'd', '2', '3', '4', '1'),
                listOf('a', 'b', 'c', '9', 'e', 'f', 'g', 'd', '2', '3', '4', '1', '6', '7', '8', '5'),
                listOf('e', 'f', 'g', 'd', '2', '3', '4', '1', '6', '7', '8', '5', 'a', 'b', 'c', '9'),
                listOf('3', '4', '1', '2', '7', '8', '5', '6', 'b', 'c', '9', 'a', 'f', 'g', 'd', 'e'),
                listOf('7', '8', '5', '6', 'b', 'c', '9', 'a', 'f', 'g', 'd', 'e', '3', '4', '1', '2'),
                listOf('b', 'c', '9', 'a', 'f', 'g', 'd', 'e', '3', '4', '1', '2', '7', '8', '5', '6'),
                listOf('f', 'g', 'd', 'e', '3', '4', '1', '2', '7', '8', '5', '6', 'b', 'c', '9', 'a'),
                listOf('4', '1', '2', '3', '8', '5', '6', '7', 'c', '9', 'a', 'b', 'g', 'd', 'e', 'f'),
                listOf('8', '5', '6', '7', 'c', '9', 'a', 'b', 'g', 'd', 'e', 'f', '4', '1', '2', '3'),
                listOf('c', '9', 'a', 'b', 'g', 'd', 'e', 'f', '4', '1', '2', '3', '8', '5', '6', '7'),
                listOf('g', 'd', 'e', 'f', '4', '1', '2', '3', '8', '5', '6', '7', 'c', '9', 'a', 'b'),
            ),
        ),
        correctAnswer = false,
    )

    test(
        name = "When passing board with size 9 and contains a cell out of range (1 to 9)" +
                " it should return false",
        result = isValidSudokuBoard(
            sudokuBoard = listOf(
                listOf('1', '9', 'a', '3', '6', '9', '2', '5', '7'),
                listOf('6', '7', '1', '4', '5', '2', '8', '3', '9'),
                listOf('5', '2', '3', '7', '9', '8', '1', '6', '4'),
                listOf('4', '8', '7', '6', '3', '5', '9', '2', '1'),
                listOf('9', '1', '6', '8', '2', '7', '3', '4', '5'),
                listOf('3', '5', '2', '9', '1', '4', '6', '7', '8'),
                listOf('1', '3', '9', '5', '7', '6', '4', '8', '2'),
                listOf('7', '6', '8', '2', '4', '9', '5', '1', '3'),
                listOf('2', '4', '5', '1', '8', '3', '7', '9', '6'),
            ),
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
