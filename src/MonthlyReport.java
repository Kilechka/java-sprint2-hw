import java.util.ArrayList;


public class MonthlyReport {
    public ArrayList<Month> monthly = new ArrayList<>();


    public void loadFile() {
        FileReader fileReader = new FileReader();
        String path;
        String content;
        for (int i = 1; i <= 3; i++) {
            path = "m.20210" + i + ".csv";
            content = fileReader.readFileContents(path);


            String[] lines = content.split("\r?\n");
            String name;
            boolean isExpense;
            int quantity;
            int unitPrice;
            int monthName = i;

            for (int f = 1; f < lines.length; f++) {
                String line = lines[f];
                String[] parts = line.split(",");
                name = parts[0];
                isExpense = Boolean.parseBoolean(parts[1]);
                quantity = Integer.parseInt(parts[2]);
                unitPrice = Integer.parseInt(parts[3]);

                Month month = new Month(name, isExpense, quantity, unitPrice, monthName);
                monthly.add(month);
            }
        }


    }

    public void mostIncome() {

        String name = "";
        int sum = 0;
        int maxProfit = 0;
        for (int i = 1; i <= 3; i++) {
            for (Month month : monthly) {
                if (month.monthName == i) {
                    if (month.isExpense == true) {
                        continue;
                    } else {
                        sum = month.unitPrice * month.quantity;
                        if (maxProfit < sum) {
                            maxProfit = sum;
                            name = month.name;
                        }
                    }

                }

            }
            System.out.println("Месяц № " + i);
            System.out.println(name + " - " + maxProfit);
            maxProfit = 0;
        }

    }


    public void mostExpense() {
        String name = "";
        int sum = 0;
        int maxExpense = 0;
        for (int i = 1; i <= 3; i++) {
            for (Month month : monthly) {
                if (month.monthName == i) {
                    if (month.isExpense != true) {
                        continue;
                    } else {
                        sum = month.unitPrice * month.quantity;
                        if (maxExpense < sum) {
                            maxExpense = sum;
                            name = month.name;
                        }
                    }

                }

            }
            System.out.println("Месяц № " + i);
            System.out.println(name + " - " + maxExpense);
            maxExpense = 0;
        }

    }
}