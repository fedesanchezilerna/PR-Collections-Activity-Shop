package shop;

public class Product {
    private static int idNext = 1;

    private String id;
    private String name;
    private Size size;
    private float price;
    private boolean active;

    public Product(String name, float price, Size size, boolean active) {
        this.name = name;
        this.size = size;
        this.active = active;
        
        // Generate ID - e.g. XXXXX-AAAAA-BB
        this.id = generateId(name, size);

        // Apply size extra price if applicable
        this.price = round(price * (1 + size.getExtraPrice()), (byte)2);
    }

    private static String generateId(String name, Size size) {
        String numPart = String.format("%05d", idNext++);
        String namePart = (name.length() > 5) ? name.substring(0, 5).toUpperCase() : name.toUpperCase();
        while (namePart.length() < 5) namePart += " "; // CONSULTAR SI SE AGREGA O NO
        String sizePart = size.name();
        return numPart + "-" + namePart + "-" + sizePart;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public Size getSize() {
        return size;
    }

    public boolean isActive() {
        return active;
    }

    public static float round(float price, byte dec) {
        float factor = (float) Math.pow(10, dec);
        return Math.round(price * factor) / factor;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | $" + price + " | " + size + " | Active: " + active;
    }
}
