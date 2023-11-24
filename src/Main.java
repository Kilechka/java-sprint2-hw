import java.util.Scanner;
import java.util.HashMap;

public class Main {
/*
Я знаю, что в некоторых моментах код написан некорретно и нужно было сделать иначе.
Я пыталась исправить это, но в итоге было потрачено много времени в пустую.
Поэтому я решила сдать работу в надежде, что вы сможете меня направить в нужное русло и поставить на путь истины.
Заранее благодарна!
 */
    public static void main(String[] args) {

        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                monthlyReport.loadFile("Январь","m.202101.csv");
                monthlyReport.loadFile("Февраль","m.202102.csv");
                monthlyReport.loadFile("Март", "m.202103.csv");
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
                    System.out.println();
                    HashMap<String, Integer> income = monthlyReport.mostIncome("Январь");
                    HashMap<String, Integer> exp = monthlyReport.mostExpense("Январь");
                    System.out.println("Самый прибыльный товар:");
                    System.out.println(income.keySet() + " - " + income.values());
                    System.out.println("Самая большая трата:");
                    System.out.println(exp.keySet() + " - " + exp.values());
                    System.out.println();
                    HashMap<String, Integer> income1 = monthlyReport.mostIncome("Февраль");
                    HashMap<String, Integer> exp1 = monthlyReport.mostExpense("Февраль");
                    System.out.println("Самый прибыльный товар:");
                    System.out.println(income1.keySet() + " - " + income1.values());
                    System.out.println("Самая большая трата:");
                    System.out.println(exp1.keySet() + " - " + exp1.values());
                    System.out.println();
                    HashMap<String, Integer> income2 = monthlyReport.mostIncome("Март");
                    HashMap<String, Integer> exp2 = monthlyReport.mostExpense("Март");
                    System.out.println("Самый прибыльный товар:");
                    System.out.println(income2.keySet() + " - " + income2.values());
                    System.out.println("Самая большая трата:");
                    System.out.println(exp2.keySet() + " - " + exp2.values());
                }

            } else if (command == 5) {
                if (yearlyReport.yearly.isEmpty()) {
                    System.out.println("Вы не считали годовой отчёт.");
                }
                else {
                    HashMap<Integer, Integer> exp = yearlyReport.expense();
                    System.out.println("Информация об отчёте 2021 года:");
                    System.out.println("Прибыль по каждому месяцу:");
                    for (Integer a : exp.keySet()) {
                        System.out.println(a + " месяц - " + exp.get(a));
                    }
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

