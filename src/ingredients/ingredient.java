package ingredients;

public class ingredient {

    int price;
    String name;
    int stock;

    public ingredient(int price, String name, int stock) {
        this.price = price;
        this.name = name;
        this.stock = stock;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
