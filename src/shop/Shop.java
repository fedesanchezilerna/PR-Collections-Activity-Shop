package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private final String name;
    private final List<Product> products;

    public Shop(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public boolean addProduct(Product product) {
        return products.add(product);
    }

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    public boolean removeById(String id) {
        return products.removeIf(product -> product.getId().equals(id));
    }

    public int numProducts() {
        return products.size();
    }

    public float total() {
        float sum = 0;
        for (Product p : products) {
            if (p.isActive()) {
                sum += p.getPrice();
            }
        }
        return Product.round(sum, (byte) 2);

        // return (float) products.stream().mapToDouble(Product::getPrice).sum();
        // .stream ->>> facilita operaciones como filter() - transformación mapToDouble() - reducción sum()
    }

    public float totalBySize(Size size) {
        float sum = 0;
        for (Product p : products) {
            if (p.isActive() && p.getSize() == size) {
                sum += p.getPrice();
            }
        }
        return Product.round(sum, (byte) 2);
    }

    public List<Product> listProductsNameAndSize (String text, Size size) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toUpperCase().contains(text.toUpperCase()) && p.getSize() == size) {
                result.add(p);
            }
        }
        return result;
    }

    public float average() {
        int count = 0;
        float sum = 0;
        for (Product p : products) {
            if (p.isActive()) {
                sum += p.getPrice();
                count++;
            }
        }
        return count > 0 ? Product.round(sum / count, (byte) 2) : 0;

//        long count = products.stream().filter(Product::isActive).count();
//        if (count == 0) return 0;
//        return total() / count;
    }

    public void printProducts() {
        products.forEach(System.out::println);
    }
}
