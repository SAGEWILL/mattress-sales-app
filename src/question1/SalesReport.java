package question1;

import java.util.Scanner;

public class SalesReport {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int[][] sales = new int[names.length][3];

        for (int p = 0; p < names.length; p++) {
            for (int m = 0; m < 3; m++) {
                sales[p][m] = readSales(input, m + 1, names[p]);
            }
            System.out.println();
        }

        Product product = new Product(names, sales);
        PrintProduct printer = new PrintProduct();

        printer.PrintHeader();
        printer.PrintTotalProductSales(product);
        printer.PrintAverageProductSales(product);
        printer.PrintMostPopularProduct(product);
    }

    // keeps asking until a valid whole number (0 or more) is entered
    private static int readSales(Scanner input, int month, String name) {
        while (true) {
            System.out.print("Enter number of sales for month " + month + " for " + name + " mattress: ");
            String line = input.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= 0) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // fall through to the message below
            }
            System.out.println("Please enter a whole number of 0 or more.");
        }
    }
}
