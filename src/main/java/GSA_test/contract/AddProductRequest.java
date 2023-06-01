package GSA_test.contract;

public class AddProductRequest {
    String name;
    double unitPrice;
    int quantityInStock;
    int supplierId;

    public AddProductRequest() {
    }

    public AddProductRequest(String name, double unitPrice, int quantityInStock, int supplierId) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
