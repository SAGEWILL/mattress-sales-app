package question1;

public class Product implements IProduct {

    // single dimensional arrays
    private final String[] productNames;
    private final int[] productTotals;

    // two dimensional array: rows = products, columns = months
    private final int[][] sales;

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
        this.productTotals = new int[productNames.length];

        // work out the total for each product over the three months
        for (int p = 0; p < sales.length; p++) {
            for (int m = 0; m < sales[p].length; m++) {
                productTotals[p] += sales[p][m];
            }
        }
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int t : productTotals) {
            total += t;
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int count = 0;
        for (int[] row : sales) {
            count += row.length;
        }
        if (count == 0) {
            return 0;
        }
        return (double) GetTotalProductsSold() / count;
    }

    @Override
    public String GetMostPopularProduct() {
        int best = 0;
        for (int i = 1; i < productTotals.length; i++) {
            if (productTotals[i] > productTotals[best]) {
                best = i;
            }
        }
        return productNames[best] + " (" + productTotals[best] + ")";
    }
}
