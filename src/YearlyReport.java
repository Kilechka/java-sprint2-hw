import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    ArrayList<Year> yearly = new ArrayList<>();

    public void loadFile(String path) {
        FileReader fileReader = new FileReader();
        String content = fileReader.readFileContents(path);
        String[] lines = content.split("\r?\n");
        int month;
        boolean isExpense;
        int amount;

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            month = Integer.parseInt(parts[0]);
            isExpense = Boolean.parseBoolean(parts[2]);
            amount = Integer.parseInt(parts[1]);

            Year year = new Year(month, amount, isExpense);
            yearly.add(year);
        }
    }
    public void expense() {
        HashMap<Integer, Integer> exp = new HashMap<>();
        for (Year year : yearly) {
            if (year.isExpense) {
                exp.put(year.month, exp.getOrDefault(year.month, 0) - year.amount);
            }
            if (!year.isExpense) {
                exp.put(year.month, exp.getOrDefault(year.month, 0) + year.amount);
            }
        }
        for (Integer a : exp.keySet()) {
            System.out.println(a + " месяц - " + exp.get(a));
        }
    }
    public int averageExpense() {
        int average = 0;
        HashMap<Integer, Integer> exp = new HashMap<>();
        for (Year year : yearly) {
            if ((year.isExpense == true)) {
                exp.put(year.month, exp.getOrDefault(year.month, 0) + year.amount);
            }

        }
        for (int i = 1; i <= exp.size(); i++) {
            average += exp.get(i);
        }
       average = average / exp.size();
        return average;
    }
    public int averageIncome() {
        int average = 0;
        HashMap<Integer, Integer> exp = new HashMap<>();
        for (Year year : yearly) {
            if ((!year.isExpense)) {
                exp.put(year.month, exp.getOrDefault(year.month, 0) + year.amount);
            }

        }
        for (int i = 1; i <= exp.size(); i++) {
            average += exp.get(i);
        }
        average = average / exp.size();
        return average;
    }

}
