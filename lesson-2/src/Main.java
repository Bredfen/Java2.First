

import java.io.IOException;
import java.util.Arrays;

/*

 1. Есть строка вида: "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
 (другими словами матрица 4x4)

 1 3 1 2
 2 3 2 2
 5 6 7 1
 3 3 1 0

 Написать метод, на вход которого подаётся такая строка,
 метод должен преобразовать строку в двумерный массив типа String[][];

 2. Преобразовать все элементы массива в числа типа int,
 просуммировать, поделить полученную сумму на 2, и вернуть результат;

 3. Ваши методы должны бросить исключения с собственными названиями в случаях:
    Если размер матрицы, полученной из строки, не равен 4x4;
    Если в одной из ячеек полученной матрицы не число; (например символ или слово)

 4. В методе main необходимо вызвать полученный метод,
 обработать возможные исключения и вывести результат расчета.
* */

public class Main {
    private static final int MATRIX_ROWS = 4;
    private static final int MATRIX_COLS = 4;


    private static final String CORRECT_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";
    private static final String EXTRA_ROW_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0\n1 2 3 4";
    private static final String EXTRA_COL_STRING = "1 3 1 2 1\n2 3 2 2 1\n5 6 7 1 1\n3 3 1 0 1";
    private static final String NO_ROW_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1";
    private static final String NO_COL_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1";
    private static final String HAS_CHAR_STRING = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 A";
    private static final boolean DEBUG_OUTPUT_MATRIX = true;

    private static final class RowMismatchException extends RuntimeException {
        RowMismatchException(String message) {
            super("Rows exception: " + message);
        }
    }

    private static final class ColumnMismatchException extends RuntimeException {
        ColumnMismatchException(String message) {
            super("Columns exception: " + message);
        }
    }

    private static final class NotANumberException extends RuntimeException {
        NotANumberException(String message) {
            super("Not a number found: " + message);
        }
    }



    private static String[][] stringToMatrix(String value) {
        String[] rows = value.split("\n");
        if (rows.length != MATRIX_ROWS)
            throw new RowMismatchException(rows.length + ":\n" + value);

        String[][] result = new String[MATRIX_ROWS][];
        for (int i = 0; i < result.length; i++) {
            result[i] = rows[i].split(" ");
            if (result[i].length != MATRIX_COLS)
                throw new ColumnMismatchException(result[i].length + ":\n" + value);
        }
        return result;
    }

    static void output_sqr(String[][] s){
        System.out.print(" |");
        for (int i = 0; i < s.length; i++)
            System.out.print(i+" ");
        System.out.println();
        System.out.print("-|");
        for (int i = 0; i < s.length; i++)
            System.out.print("--");
        System.out.println();


        for (int i = 0; i < s.length; i++) {
            System.out.print(i+"|");
            for (int j = 0; j < s.length; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static float halfSumMatrix(String[][] matrix) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    result += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new NotANumberException(matrix[i][j] + "\nin ROW = "+i + ", COL = " + j);
                }
            }
        }
        return result / 2f;
    }

    public static void main(String[] args) {
        try {
            //final String[][] matrix = stringToMatrix(CORRECT_STRING);
            //final String[][] matrix = stringToMatrix(NO_ROW_STRING);
            //final String[][] matrix = stringToMatrix(NO_COL_STRING);
            final String[][] matrix = stringToMatrix(EXTRA_COL_STRING);
            //final String[][] matrix = stringToMatrix(EXTRA_ROW_STRING);
            //final String[][] matrix = stringToMatrix(HAS_CHAR_STRING);
            if (DEBUG_OUTPUT_MATRIX){
              output_sqr(matrix);
            } else {
                System.out.println(Arrays.deepToString(matrix));
            }
            System.out.println("Half sum = " + halfSumMatrix(matrix));
        } catch (NotANumberException e) {
            System.out.println("A NumberFormatException is thrown: " + e.getMessage());
        } catch (RowMismatchException | ColumnMismatchException e) {
            System.out.println("A RuntimeException successor is thrown: " + e.getMessage());
        }
    }

}
