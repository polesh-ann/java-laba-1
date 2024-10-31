package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите x и k");
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int k = scanner.nextInt();
        if(k < 0){
            System.out.println("неправильное значение");
        } else{
            double cosh = Math.cosh(x);
            System.out.println("Вычислено через стандартную функцию:");
            System.out.println(cosh);
            System.out.println("Вычислено мной:");
            System.out.println(Cosh.getTaylorCosh(x, k));
        }
    }
}

