
//Austin Marcoux
//1099028

package Models;

import com.google.gson.annotations.SerializedName;

public class Product {
    private int id;
    private double salePrice, regularPrice;
    private String name, sku;
    @SerializedName("images")
    private String imageURL;

    public Product(int id, double salePrice, double regularPrice, String name, String sku, String imageURL) {
        setId(id);
        setSalePrice(salePrice);
        setRegularPrice(regularPrice);
        setName(name);
        setSku(sku);
        setImageURL(imageURL);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegularPrice(double regularPrice) {
        this.regularPrice = regularPrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getId() {
        return id;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", salePrice=" + salePrice +
                ", regularPrice=" + regularPrice +
                ", name='" + name + '\'' +
                ", sku='" + sku + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
