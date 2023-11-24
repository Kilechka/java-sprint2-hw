import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    public ArrayList<Month> monthly = new ArrayList<>();



    public void loadFile(String monthName, String path) {
        FileReader fileReader = new FileReader();
        String content = fileReader.readFileContents(path);
        String[] lines = content.split("\r?\n");
        String name;
        boolean isExpense;
        int quantity;
        int unitPrice;

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            name = parts[0];
            isExpense = Boolean.parseBoolean(parts[1]);
            quantity = Integer.parseInt(parts[2]);
            unitPrice = Integer.parseInt(parts[3]);


            Month month = new Month(name, isExpense, quantity, unitPrice, monthName);
            monthly.add(month);
        }

    }
    public HashMap<String, Integer> mostIncome(String monthName) { //самый прибыльный товар, название товара и сумму;
    HashMap<String, Integer> income = new HashMap<>();
    String name = "";
    int sum = 0;
    int maxProfit = 0;
    for(Month month : monthly) {
        if (month.monthName != monthName) {
            continue;
        }
            if (month.isExpense == false) {
                sum = month.unitPrice * month.quantity;
                if (maxProfit < sum) {
                    maxProfit = sum;
                    name = month.name;
                }
            }

    }
    income.put(name, sum);
    return income;
    }
    public HashMap<String, Integer> mostExpense(String monthName) {
        HashMap<String, Integer> mostExpense = new HashMap<>();
        String name = "";
        int sum = 0;
        int mostSpending = 0;
        for(Month month : monthly) {
            if(month.isExpense == true) {
                if (month.monthName != monthName) {
                    continue;
                }
                sum = month.unitPrice * month.quantity;
                if(mostSpending < sum) {
                    mostSpending = sum;
                    name = month.name;
                }
            }
        }
        mostExpense.put(name, sum);
        System.out.println(monthName + ":");
        return mostExpense;
    }

}