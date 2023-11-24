import java.util.ArrayList;
import java.util.HashMap;

public class Cheker {
    public YearlyReport yearlyReport;
    public MonthlyReport monthlyReport;
    public Cheker(YearlyReport yearlyReport, MonthlyReport monthlyReport) {
        this.yearlyReport = yearlyReport;
        this.monthlyReport = monthlyReport;
    }
    public boolean chek() {
     //  HashMap<String, HashMap<String, Integer>> inCome = new HashMap<>();
        HashMap<String, Integer> monthlyinCome = new HashMap<>();
        HashMap<String, Integer> monthlyExpense = new HashMap<>();
        boolean compare = true;

        for (Month month : monthlyReport.monthly) {
            int sumExpense;
            int suminCome;
            if (month.isExpense == true) {
                sumExpense = month.quantity * month.unitPrice;
                monthlyExpense.put(month.monthName, monthlyExpense.getOrDefault(month.monthName, 0) + sumExpense);
            }
            else {
                suminCome = month.quantity * month.unitPrice;
                monthlyinCome.put(month.monthName, monthlyinCome.getOrDefault(month.monthName, 0) + suminCome);
            }
        }


        for (Year year : yearlyReport.yearly) {

            if (year.isExpense == false) {
                if (year.month == 01) {
                    if (year.amount != monthlyinCome.get("Январь")) {
                        System.out.println("Сумма прибыли в январе не сходится с суммой прибыли января в годовом отчёте");
                        compare = false;
                    }
                }
                else if (year.month == 02) {
                    if (year.amount != monthlyinCome.get("Февраль")) {
                        System.out.println("Сумма прибыли в феврале не сходится с суммой прибыли февраля в годовом отчёте");
                        compare = false;
                    }

                }
                else if (year.month == 03) {
                    if (year.amount != monthlyinCome.get("Март")) {
                        System.out.println("Сумма прибыли в марте не сходится с суммой прибыли марта в годовом отчёте");
                        compare = false;
                    }

                }
            }
            else if (year.isExpense == true) {
                if (year.month == 01) {
                    if (year.amount != monthlyExpense.get("Январь")) {
                        System.out.println("Сумма расходов в январе не сходится с суммой расходов января в годовом отчёте");
                        compare = false;
                    }

                }
                else if (year.month == 02) {
                    if (year.amount != monthlyExpense.get("Февраль")) {
                        System.out.println("Сумма расходов в феврале не сходится с суммой расходов февраля в годовом отчёте");
                        compare = false;
                    }

                }
                else if (year.month == 03) {
                    if (year.amount != monthlyExpense.get("Март")) {
                        System.out.println("Сумма расходов в марте не сходится с суммой расходов марта в годовом отчёте");
                        compare = false;
                    }

                }
            }

        }
        return compare;
    }
}
