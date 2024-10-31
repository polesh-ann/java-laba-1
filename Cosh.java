package org.example;

import static java.lang.Math.*;

public class Cosh {

    public static Double getSigma(int k) {
        return pow(10, -k);
    }

    public static double getTaylorCosh(double x, int k) {
        Double sigma = Cosh.getSigma(k);
        double sum = 1;
        double x2 = pow(x, 2);
        double slag = 1;
        double factor = 0;
        do {
            slag *= x2/ ++factor / ++factor;
            sum+=slag;
        }while (slag>sigma);
        return sum;
    }
}
