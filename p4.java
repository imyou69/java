import java.util.Scanner;

class ExceptionDemo {
    public static void main(String[] args) {
        int a, b, result;
        Scanner input = new Scanner(System.in);
        System.out.println("Input two integers");
        a = input.nextInt();
        b = input.nextInt();

        try {
            result = a / b;
            System.out.println("Result = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: Divide by zero error " + e);
        }

        int array[] = {2, 3, 4, 5, 6};

        try {
            System.out.println("Accessing array element: " + array[5]);
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("Array index out of bound " + e1);
        }
    }
}
