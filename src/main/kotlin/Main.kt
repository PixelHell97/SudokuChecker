package org.example

fun main() {
    isValidSudokuBoard(
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
    )
}

fun isValidSudokuBoard(
    sudokuBoard: List<List<Char>>,
): Boolean {
    if (!isBoardSquared(sudokuBoard)) return false

    val boardSize = sudokuBoard.size

    if (!isInputsInRange(sudokuBoard, boardSize)) return false

    sudokuBoard.forEach { row ->
        if (hasDuplication(row)) {
            return false
        }
    }

    for (i in sudokuBoard.indices) {
        val column = sudokuBoard.map { it[i] }

        if (hasDuplication(column)) {
            return false
        }
    }

    val subgridSize = when (boardSize) {
        4 -> 2
        9 -> 3
        16 -> 4
        else -> return false
    }

    for (i in 0 until boardSize step subgridSize) {
        for (j in 0 until boardSize step subgridSize) {
            val subgrid = mutableListOf<Char>()

            for (row in i until i + subgridSize) {
                for (col in j until j + subgridSize) {
                    subgrid.add(sudokuBoard[row][col])
                }
            }

            if (hasDuplication(subgrid)) return false
        }
    }

    return true
}

private fun isInputsInRange(board: List<List<Char>>, boardSize: Int): Boolean {
    val validChars: Set<Char> = when (boardSize) {
        4 -> ('1'..'4').toSet()
        9 -> ('1'..'9').toSet()
        16 -> (('1'..'9') + ('A'..'G')).toSet()
        else -> return false
    }

    return board.flatten().all { it == '-' || it.uppercaseChar() in validChars }
}

private fun hasDuplication(group: List<Char>): Boolean {
    val seen = mutableListOf<Char>()
    for (num in group) {
        if (num != '-') {
            if (seen.contains(num)) {
                return true
            } else {
                seen.add(num)
            }
        }
    }
    return false
}

private fun isBoardSquared(sudokuBoard: List<List<Char>>): Boolean {
    sudokuBoard.forEach { row ->
        if (row.size != sudokuBoard.size) {
            return false
        }
    }
    return true
}
