package question1;

import java.text.DecimalFormat;

public class PrintProduct {

    public void PrintHeader() {
        System.out.println();
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println();
        System.out.println("*********************************************");
    }

    public void PrintTotalProductSales(IProduct product) {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void PrintAverageProductSales(IProduct product) {
        // 0.## so 17.0 shows as 17 like the sample
        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println("AVERAGE PRODUCT SALES: " + df.format(product.GetAverageProductSold()));
    }

    public void PrintMostPopularProduct(IProduct product) {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}
