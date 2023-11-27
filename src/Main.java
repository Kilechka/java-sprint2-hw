import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                monthlyReport.loadFile();
                System.out.println("Месячные отчёты считаны!");

            } else if (command == 2) {
                yearlyReport.loadFile("y.2021.csv");
                System.out.println("Годовой отчёт считан!");

            } else if (command == 3) {
                if (monthlyReport.monthly.isEmpty()) {
                    System.out.println("Вы не считали месячные отчёты.");
                    if (yearlyReport.yearly.isEmpty()) {
                        System.out.println("Вы не считали годовой отчёт.");
                    }
                }
                else if (yearlyReport.yearly.isEmpty()) {
                    System.out.println("Вы не считали годовой отчёт.");
                }
                else {
                    Cheker cheker = new Cheker(yearlyReport, monthlyReport);
                    System.out.println("Результат сверки отчётов - " + cheker.chek());

                }

            } else if (command == 4) {
                if (monthlyReport.monthly.isEmpty()) {
                    System.out.println("Вы не считали месячные отчёты.");
                }
                else {
                    System.out.println("Информация о месячных отчётах:");
                    System.out.println("Самый прибыльный товар: ");
                    monthlyReport.mostIncome();
                    System.out.println("Самая большая трата: ");
                    monthlyReport.mostExpense();

                }

            } else if (command == 5) {
                if (yearlyReport.yearly.isEmpty()) {
                    System.out.println("Вы не считали годовой отчёт.");
                }
                else {
                    System.out.println("Информация об отчёте 2021 года:");
                    System.out.println("Прибыль по каждому месяцу:");
                    yearlyReport.expense();
                    System.out.println("Средний расход за все имеющиеся операции в году: " + yearlyReport.averageExpense());
                    System.out.println("Средний доход за все имеющиеся операции в году: " + yearlyReport.averageIncome());


                }
            } else if (command == 0) {
                System.out.println("Выход");
                scanner.close();
                return;
            } else {
                System.out.println("Извините, такой команды пока не существует");
            }
        }
    }

    static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию обо всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выйти");

    }

}

