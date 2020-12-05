package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("D:\\Теорія прийняття рішень\\matrixLab_2.txt")));
        
        double[] m1 = new double[5];
        double[] m2 = new double[5];
        double[] m3 = new double[4];
        double M1, M2, M3, M31, M32;
        double[][] matrix = new double[3][5];
        while (sc.hasNextLine()) {
            for (int i = 0; i < matrix.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j = 0; j < line.length; j++) {
                    matrix[i][j] = Double.parseDouble(line[j]);
                }

            }
        }

        for (int i = 0; i < 5; i++) {
            m1[i] = matrix[0][i];
            m2[i] = matrix[1][i];
            if (i < 4) {
                m3[i] = matrix[2][i];
            }
        }

        System.out.println("Побудувати великий завод: \n M1=" + m1[0] + ", D1=" + m1[1] + ", p1=" + m1[2] + ", D2=" + m1[3] + ", p2=" + m1[4]);
        System.out.println("Побудувати маленький завод: \n M2=" + m2[0] + ", D1=" + m2[1] + ", p1=" + m2[2] + ", D2=" + m2[3] + ", p2=" + m2[4]);
        System.out.println("Відкласти будівництво заводу на 1 рік: \n M3: p3=" + m3[0] + ", p4=" + m3[1] + ", p1=" + m3[2] + ", p2=" + m3[3]);
        System.out.println();

        M1 = Pm(m1[2], m1[4], m1[1], m1[3]);
        M2 = Pm(m2[2], m2[4], m2[1], m2[3]);
        M31 = Pm(m3[2], m3[3], m1[1], m1[3]);
        M32 = Pm(m3[2], m3[3], m2[1], m2[3]);

        System.out.println("Дохід якщо побудувати великий завод = " + m1[2] + "*" + Integer.toString((int) m1[1]) + "-" + m1[4] + "*" + Integer.toString((int) Math.abs(m1[3])) + " = " + M1 + "x5 з втратами -" + Integer.toString((int) m1[0]) + ": " + (M1 * 5 - m1[0])+ " тис. доларів.");
        System.out.println("Дохід якщо побудувати малий завод = " + m2[2] + "*" + Integer.toString((int) m2[1]) + "-" + m2[4] + "*" + Integer.toString((int) Math.abs(m2[3])) + " = " + M2 + "x5 з втратами -" + Integer.toString((int) m2[0]) + ": " + (M2 * 5 - m2[0])+ " тис. доларів.");

        System.out.println("Дохід якщо побудувати великий завод через рік = " + m3[2] + "*" + Integer.toString((int) m1[1]) + "-" + m3[3] + "*" + Integer.toString((int) Math.abs(m1[3])) + " = " + M31 + "x4 з втратами -" + Integer.toString((int) m1[0]) + ": " + (M31 * 4 - m1[0])+ " тис. доларів.");
        System.out.println("Дохід якщо побудувати маленький завод через рік = " + m3[2] + "*" + Integer.toString((int) m2[1]) + "-" + m3[3] + "*" + Integer.toString((int) Math.abs(m2[3])) + " = " + M32 + "x4 з втратами -" + Integer.toString((int) m2[0]) + ": " + (M32 * 4 - m2[0])+ "тис. доларів.");
        System.out.println("Дохід якщо завод не побудується = 0*" + m3[1] + " = 0 тис. доларів.");

        System.out.println();

        M1 = M1 * 5 - m1[0];
        M2 = M2 * 5 - m2[0];
        M31 = M31 * 4 - m1[0];
        M32 = M32 * 4 - m2[0];

        if (M31 > M32) {
            M3 = M31;

        } else {
            M3 = M32;

        }
        System.out.println();

        if (M3<0) {
            M3 = 0;

        }
        else if (M31 > M32) {
                       System.out.println("Оскільки дохід від побудованого великого заводу через рік більший за побудову малого, отже, подія 3 = " + Integer.toString((int) M31));
        } else {
                    System.out.println("Оскільки дохід від побудованого малого заводу через рік більший за побудову великого, отже, подія 3 = " + Integer.toString((int) M32));
        }

        System.out.println();
        System.out.println("Дохід якщо побудувати великий завод = " + M1 + " тис. доларів.");
        System.out.println("Дохід якщо побудувати малий завод = " + M2+ " тис. доларів.");
        System.out.println("Дохід побудувати завод через рік = " + M3+ " тис. доларів.");

        System.out.println();
        if (M1 > M2) {
            if (M1 > M3) {
                System.out.println("Найкраще рішення - побудувати великий завод з доходом " + M1);
            } else
                System.out.println("Найкраще рішення - відкласти будівництво заводу на 1 рік з доходом " + M3+ " тис. доларів.");
        } else if (M2 > M3) {
            System.out.println("Найкраще рішення - побудувати маленький завод з доходом " + M2  );
        } else
            System.out.println("Найкраще рішення - відкласти будівництво заводу на 1 рік з доходом " + M3 + " тис. доларів.");

    }

    public static double Pm(double p1, double p2, double d1, double d2){
        double Pm;
        Pm=p1*d1-Math.abs(p2*d2);
        return Pm;
    }

}