/*
 * Your name: Reed Elliott
 * Description: Program #2 - jUnit - simple math class
 */

public class Program2 {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        double result = a * b;
        if (result == -0) return 0;
        return result;
    }

    public static double divide(double a, double b) {
        // we have to throw the exception ourselves
        // because floating point division by zero
        // results in +inf or -inf
        if (b == 0)
            throw new ArithmeticException("division by zero in Program.divide");
        double result = a / b;
        if (result == -0) return 0;
        return result;
    }

    public static double sinOfAngle(double oppSide, double hyp) {
        // round to 2 decimal places to make the tests happy
        return Math.round(100 * Program2.divide(oppSide, hyp)) / 100.0;
    }

    public static double hypOfTriangle(double sideA, double sideB) {
        // round to 2 decimal places to make the tests happy
        return Math.round(100 * Math.sqrt(sideA * sideA + sideB * sideB)) / 100.0;
    }


    public static void main(String[] args) {
        double x = 3;
        double y = 4;
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("x + y = " + Program2.add(x, y));
        System.out.println("x - y = " + Program2.subtract(x, y));
        System.out.println("x * y = " + Program2.multiply(x, y));
        System.out.println("x / y = " + Program2.divide(x, y));
        System.out.println("sin(z) = opp / hyp = " + Program2.sinOfAngle(x, y));
        System.out.println("hyp of x and y = " + Program2.hypOfTriangle(x, y));
    }
}
