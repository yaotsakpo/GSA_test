package GSA_test.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.*;

@Entity
public class supplier {
    @Id
    @GeneratedValue
    private int supplierId;
    private String name;
    private String contactPhone;

    public supplier() {
    }

    public supplier(int supplierId, String name, String contactPhone) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactPhone = contactPhone;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
