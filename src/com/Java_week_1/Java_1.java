package com.Java_week_1;

import java.util.Scanner;

public class Java_1 {

    public static void main(String[] args) {
//        int number = checkNumber();
//        checkPrime(number);
//        numberOfPrime();
        int[] arr = inputArray();
        outputArray(arr);
        primeInArray(arr);
        checkArray(arr);
        deleteArray(arr);
        sortArray(arr);
        insertArray(arr);
    }

    public static int checkNumber() {
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập số N lẻ dương: ");
            int n = scanner.nextInt();
            if (n % 2 == 1) return n;
            else System.out.print("Số N không thoả mãn, ");
        } while (true);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void checkPrime(int n) {
        if (isPrime(n)) {
            System.out.println(n + " là số nguyên tố!");
        } else {
            System.out.println(+n + " không phải số nguyên tố!");
        }
    }

    public static void numberOfPrime() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập các số nguyên tố đầu cần in ra: ");
        int n = scanner.nextInt();
        System.out.printf("%d số nguyên tố đầu tiên là: \n", n);
        int count = 0;
        int i = 2;
        while (count < n) {
            if (isPrime(i)) {
                System.out.print(i + " ");
                count++;
            }
            i++;
        }
    }

    public static int[] inputArray() {
        int n;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("\nNhập vào số phần tử của mảng: ");
            n = scanner.nextInt();
        } while (n < 0);

        int array[] = new int[n];
        System.out.println("Nhập các phần tử cho mảng: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void outputArray(int array[]) {

        System.out.println("\nMảng vừa nhập là: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public static void primeInArray(int array[]) {
        System.out.print("\nCác số nguyên tố trong mảng: ");
        for (int i : array) {
            if (isPrime(i)) {
                System.out.print(i + "\t");
            }
        }
    }

    public static int checkArray(int array[]) {
        System.out.print("\nNhập giá trị để kiểm tra: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] == n) {
                System.out.println(n + " nằm trong mảng và ở vị trí " + i);
                break;
            }
            if (i == array.length) {
                System.out.println(n + "không nằm trong mảng");
            }
        }
        return n;
    }

    public static int[] deleteArray(int array[]) {
        System.out.print("\nNhập số cần xoá: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int c, i;
        int n = array.length;
        for (c = i = 0; i < n; i++) {
            if (array[i] != num) {
                array[c] = array[i];
                c++;
            }
        }
        n = c;
        System.out.println("Mảng còn lại sau khi xóa phần tử " + num + " là: ");
        for (i = 0; i < n; i++) {
            System.out.print(array[i] + "\t");
        }
        return array;
    }

    public static void sortArray(int array[]) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("\nMảng sau khi sắp xếp là: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public static void insertArray(int[] array) {
        System.out.print("\nNhập phần tử cần thêm vào: ");
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int arrIndex = array.length - 1;
        int[] array2 = new int[array.length + 1];
        boolean inserted = false;

        for (int i = array.length; i >= 0; i--) {
            if (arrIndex > -1 && array[arrIndex] > x) {
                array2[i] = array[arrIndex--];
            } else {
                if (!inserted) {
                    array2[i] = x;
                    inserted = true;
                } else {
                    array2[i] = array[arrIndex--];
                }
            }
        }
        int temp;
        for (int i = 0; i < array2.length - 1; i++) {
            for (int j = i + 1; j <= array2.length - 1; j++) {
                if (array2[i] > array2[j]) {
                    temp = array2[i];
                    array2[i] = array2[j];
                    array2[j] = temp;
                }
            }
        }
        System.out.println("Mảng sau khi chèn x là: ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i] + "\t");
        }
    }

}
