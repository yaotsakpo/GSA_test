package GSA_test.domain;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
public class product {
    @Id
    @GeneratedValue
    private int productid;
    private String name;
    private double unitPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private supplier supplier;

    private int quantityInStock;
    private Date dateSupplied;

    public product() {
    }

    public product( String name, double unitPrice, int quantityInStock, supplier supplier) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.dateSupplied = new Date();
        this.supplier = supplier;
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

    public Date getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(Date dateSupplied) {
        this.dateSupplied = dateSupplied;
    }


    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public GSA_test.domain.supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(GSA_test.domain.supplier supplier) {
        this.supplier = supplier;
    }
}
