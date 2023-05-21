package org.example;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiralMatrix {


    public static List<Integer> printSpiralJk(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int i, k = 0, l = 0;

        while (k < n && l < m) {
            for (i = l; i < m; ++i) {
                spiralList.add(matrix[k][i]);
            }
            k++;

            for (i = k; i < n; ++i) {
                spiralList.add(matrix[i][m-1]);
            }
            m--;

            if (k < n) {
                for (i = m-1; i >= l; --i) {
                    spiralList.add(matrix[n-1][i]);
                }
                n--;
            }

            if (l < m) {
                for (i = n-1; i >= k; --i) {
                    spiralList.add(matrix[i][l]);
                }
                l++;
            }
        }
        return spiralList;
    }
    public static void printSpiral(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i, k = 0, l = 0;

        /*
        k - starting row index
        l - starting column index
        n - ending row index
        m - ending column index
        i - iterator
        */

        while (k < n && l < m) {
            /* Print the first row from the remaining rows */
            for (i = l; i < m; ++i) {
                System.out.println(matrix[k][i]);
            }
            k++;

            /* Print the last column from the remaining columns */
            for (i = k; i < n; ++i) {
                System.out.println(matrix[i][m-1]);
            }
            m--;

            /* Print the last row from the remaining rows */
            if ( k < n) {
                for (i = m-1; i >= l; --i) {
                    System.out.println(matrix[n-1][i]);
                }
                n--;
            }

            /* Print the first column from the remaining columns */
            if (l < m) {
                for (i = n-1; i >= k; --i) {
                    System.out.println(matrix[i][l]);
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };

        printSpiral(matrix);
    }
}

//    This problem was asked by Amazon.
//
//        Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.
//
//        For example, given the following matrix:
//
//        [[1,  2,  3,  4,  5],
//        [6,  7,  8,  9,  10],
//        [11, 12, 13, 14, 15],
//        [16, 17, 18, 19, 20]]
//        You should print out the following:
//
//        1
//        2
//        3
//        4
//        5
//        10
//        15
//        20
//        19
//        18
//        17
//        16
//        11
//        6
//        7
//        8
//        9
//        14
//        13
//        12