package org.example;

import org.apache.commons.numbers.complex.Complex;

public class Main {
    public static void main(String[] args) {
        Complex a = Complex.ofCartesian(10, 20);
        Complex b = Complex.ofCartesian(30, 40);

        Complex c = a.subtract(b);

        System.out.println("c = " + c);
    }
}