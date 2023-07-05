import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return exponentiate(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return exponentiate(amount + amount * yearRate * depositPeriod, 2);
    }

    double exponentiate(double value, int degree) {
        double ScaLe = Math.pow(10, degree);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void calculateMoneyForYears() {
        int years;
        int command;
        int amount;
        double finalSum = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        years = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        command = scanner.nextInt();
        if (command == 1) {
            finalSum = calculateSimplePercent(amount, 0.06, years);
        }
        else if (command == 2) {
            finalSum = calculateComplexPercent(amount, 0.06, years);
        }
        System.out.println("Результат вклада: " + amount + " за " + years + " лет превратятся в " + finalSum);
    }
}
