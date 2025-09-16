public class Calculator {

    public int calculate(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default:
                System.out.println("ошибка! не правильно выбран символ");
                return 0;
        }
    }


    public double calculate(double a, double b)
    {
        return a + b;
    }


    public int calculate(int... values) {
        int sum = 0;
        for (int val : values) {
            sum += val;
        }
        return sum;
    }

    // Тест
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("5 + 3 = " + calc.calculate(5, 3, '+'));
        System.out.println("2.5 + 1.5 = " + calc.calculate(2.5, 1.5));
        System.out.println("Сумма 1,2,3,4 = " + calc.calculate(1, 2, 3, 4));

    }
}
