package shop;

public class Main {

    public static void main(String[] args) {

        //1.Instantiate Shop
        System.out.println("1. Instantiate Shop:");
        Shop shop = new Shop("Gutin Store");

        //2.Instantiate Products
        System.out.println("\n2. Instantiate 20 Products with different sizes and prices:");
        Product[] products = {
                new Product("TSHIRT", 30.25f, Size.XXS, true),
                new Product("CAP", 25.75f, Size.XS, true),
                new Product("TROUSERS", 30.25f, Size.S, true),
                new Product("SKIRT", 28.25f, Size.M, true),
                new Product("GLOVES", 32.35f, Size.L, true),
                new Product("T", 23.79f, Size.XL, true),
                new Product("T", 35.25f, Size.XXL, true),
                new Product("JACKET", 59.97f, Size.XL, true),
                new Product("TSHIRT", 29.95f, Size.XS, true),
                new Product("LONG-SHIRT", 20.56f, Size.XS, true),
                new Product("TANK-TSHIRT", 16.55f, Size.XL, true),
                new Product("TSHIRT", 29.15f, Size.M, true),
                new Product("TANK-TSHIRT", 24.45f, Size.XXL, true),
                new Product("TSHIRT", 32.50f, Size.XS, true),
                new Product("LONG-SHIRT", 32.70f, Size.XS, false),
                new Product("SHIRT", 34.50f, Size.XS, false),
                new Product("TSHIRT", 33.25f, Size.XS, false),
                new Product("SLEEVELESS-SHIRT", 32.50f, Size.XS, false),
                new Product("TSHIRT", 28.50f, Size.XS, false),
                new Product("TSHIRT", 29.50f, Size.S, false),
        };

        //3.Add products Shop
        System.out.println("\n3. Add products Shop:");
        for (Product product : products) {
            shop.addProduct(product);
        }

        //4.Print all products
        System.out.println("\n4. Print all products:");
        shop.printProducts();

        //5.Print Number Products
        System.out.println("\n5. Num Products: " + shop.numProducts());

        //6. Get total price
        System.out.println("\n6. Get total: $" + shop.total());

        //7. Get total of products
        System.out.println("\n7. Get total by size:");
        System.out.println("XXS: $" + shop.totalBySize(Size.XXS));
        System.out.println("XS: $" + shop.totalBySize(Size.XS));
        System.out.println("S: $" + shop.totalBySize(Size.S));
        System.out.println("M: $" + shop.totalBySize(Size.M));
        System.out.println("L: $" + shop.totalBySize(Size.L));
        System.out.println("XL: $" + shop.totalBySize(Size.XL));
        System.out.println("XXL: $" + shop.totalBySize(Size.XXL));

        //8. List products with name "SHIRT" and size "XS"
        System.out.println("\n8. List products with name \"SHIRT\" and size \"XS\":");
        shop.listProductsNameAndSize("SHIRT", Size.XS).forEach(System.out::println);

        //9. List products with name "t" and size "XL"
        System.out.println("\n9. List products with name \"t\" and size \"XL\":");
        shop.listProductsNameAndSize("t", Size.XL).forEach(System.out::println);

        //10. Remove a product by id
        System.out.println("\n10. Remove product by id");
        shop.removeById(products[0].getId());

        //Print number of products
        System.out.println("New Num Products: " + shop.numProducts());

        //11. Remove a product
        System.out.println("\n11. Remove product by object");
        shop.removeProduct(products[1]);

        //Print number of products
        System.out.println("New Num Products: " + shop.numProducts());

        //12. Average active products
        System.out.println("\n12. Average acrive products: " + shop.average());
    }
}