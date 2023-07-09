/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pcsystem;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Uday
 */
@Entity
@Table(name = "PRODUCT_DETAILS")
@NamedQueries({@NamedQuery(name = "ProductDetails.findAll", query = "SELECT p FROM ProductDetails p"), @NamedQuery(name = "ProductDetails.findById", query = "SELECT p FROM ProductDetails p WHERE p.id = :id"), @NamedQuery(name = "ProductDetails.findByProductId", query = "SELECT p FROM ProductDetails p WHERE p.productId = :productId"), @NamedQuery(name = "ProductDetails.findByProductName", query = "SELECT p FROM ProductDetails p WHERE p.productName = :productName"), @NamedQuery(name = "ProductDetails.findByQuantity", query = "SELECT p FROM ProductDetails p WHERE p.quantity = :quantity"), @NamedQuery(name = "ProductDetails.findByMrp", query = "SELECT p FROM ProductDetails p WHERE p.mrp = :mrp"), @NamedQuery(name = "ProductDetails.findByCostPrice", query = "SELECT p FROM ProductDetails p WHERE p.costPrice = :costPrice")})
public class ProductDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @Column(name = "PRODUCT_ID")
    private String productId;
    @Basic(optional = false)
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @Column(name = "MRP")
    private BigInteger mrp;
    @Column(name = "COST_PRICE")
    private BigInteger costPrice;

    public ProductDetails() {
    }

    public ProductDetails(String id) {
        this.id = id;
    }

    public ProductDetails(String id, String productId, String productName) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public BigInteger getMrp() {
        return mrp;
    }

    public void setMrp(BigInteger mrp) {
        this.mrp = mrp;
    }

    public BigInteger getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigInteger costPrice) {
        this.costPrice = costPrice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDetails)) {
            return false;
        }
        ProductDetails other = (ProductDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pcsystem.ProductDetails[id=" + id + "]";
    }

}
