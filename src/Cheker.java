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
        HashMap<Integer, Integer> monthlyinCome = new HashMap<>();
        HashMap<Integer, Integer> monthlyExpense = new HashMap<>();
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

        for (int i = 0; i < monthlyinCome.size(); i ++) {
            for (Year year : yearlyReport.yearly) {
                if (year.isExpense) {
                    continue;
                }
                if (year.month != i + 1) {
                    continue;
                }
                if (year.amount != monthlyinCome.get(i + 1)) {
                    System.out.println("Сумма прибыли в " + (i + 1) + " месяце не сходится с суммой прибыли в годовом отчёте");
                    compare = false;
                }
            }
        }
        for (int i = 0; i < monthlyExpense.size(); i ++) {
            for (Year year : yearlyReport.yearly) {
                if (!year.isExpense) {
                    continue;
                }
                if (year.month != i + 1) {
                    continue;
                }
                if (year.amount != monthlyExpense.get(i + 1)) {
                    System.out.println("Сумма расходов в " + (i + 1) + " месяце не сходится с суммой прибыли в годовом отчёте");
                    compare = false;
                }
            }
        }
        return compare;
        }
    }


