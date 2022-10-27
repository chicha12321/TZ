package com.test;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] ar = new int[]{-5, -4, -3, -2, -1, 0, 4};
        System.out.println(method(ar));
    }

    //Максимальное произведение трех элементов
    private static int method(int[] ar) {
        //Если массив весь отрицательный и есть 0,то сразу вовзращаем 0
        if (isZero(ar)) {
            return 0;
        }
        Arrays.sort(ar);

        int leftNum = 1;
        int rightNum = 1;
        int leftIndex = 0;
        int rightIndex = 0;

        int countForAddTwoNum = 0;
//Считаем произведение двух наименьших чисел не равных 0
        for (int i = 0; i < ar.length; i++) {
            if (countForAddTwoNum != 2) {
                if (ar[i] != 0) {
                    leftNum *= ar[i];
                    leftIndex = i;
                    countForAddTwoNum++;
                }
            }
        }
//Считаем произведение двух наибольших чисел не равных 0
        countForAddTwoNum = 0;
        for (int i = ar.length - 1; i >= 0; i--) {
            if (countForAddTwoNum != 2) {
                if (ar[i] != 0) {
                    rightNum *= ar[i];
                    rightIndex = i;
                    countForAddTwoNum++;
                }
            }
        }
        //Присваеваем результаты методов по добавлению последних элементов
        int firstResult = rightNum(ar, rightNum, rightIndex);
        int secondResult = leftNum(ar, leftNum, leftIndex);
        //Проверяем на правильность результата
        if (firstResult >= rightNum) {
            rightNum = firstResult;
        }
        if (secondResult >= leftNum) {
            leftNum = secondResult;
        } else {
            return firstResult;
        }
        //Возвращаем максимальное значение
        return Math.max(leftNum, rightNum);
    }

    //Поиск последнего нужного элемента,учитывая какой результат у нас есть
    private static int rightNum(int[] ar, int rightNum, int rightIndex) {
        int countForAddOneNum = 0;
        if (rightNum > 0) {
            for (int i = rightIndex - 1; i >= 0; i--) {
                if (countForAddOneNum != 1) {
                    if (ar[i] != 0) {
                        rightNum *= ar[i];
                        countForAddOneNum++;

                    }
                }
            }
        } else {
            for (int i = 0; i < ar.length; i++) {
                if (countForAddOneNum != 1) {
                    if (ar[i] != 0) {
                        rightNum *= ar[i];
                        countForAddOneNum++;
                    }
                }
            }
        }
        return rightNum;
    }

    //Поиск последнего нужного элемента,учитывая какой результат у нас есть
    private static int leftNum(int[] ar, int leftNum, int leftIndex) {
        int countForAddOneNum = 0;
        if (leftNum > 0) {
            for (int i = ar.length - 1; i >= 0; i--) {
                if (countForAddOneNum != 1) {
                    if (ar[i] > 0) {
                        leftNum *= ar[i];
                        countForAddOneNum++;
                    }
                }
            }
            if (countForAddOneNum == 0) {
                return leftNum - 1;
            }
        } else {
            for (int i = leftIndex + 1; i < ar.length; i++) {
                if (countForAddOneNum != 1) {
                    if (ar[i] != 0) {
                        leftNum *= ar[i];
                        countForAddOneNum++;
                    }
                }
            }
        }
        return leftNum;
    }

    private static boolean isZero(int[] ar) {
        int count = 0;
        int length = 0;
        for (int j : ar) {
            if (j == 0) {
                count++;
            }
            if (j <= 0) {
                length++;
            }
        }
        return length == ar.length && count > 0;
    }

}

