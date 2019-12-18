/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.elbancodelplaza.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pmari
 */
@Entity
@Table(name = "bonds")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bonds.findAll", query = "SELECT b FROM Bonds b")
    , @NamedQuery(name = "Bonds.findByBondID", query = "SELECT b FROM Bonds b WHERE b.bondID = :bondID")
    , @NamedQuery(name = "Bonds.findByExpirationDate", query = "SELECT b FROM Bonds b WHERE b.expirationDate = :expirationDate")
    , @NamedQuery(name = "Bonds.findByPercentage", query = "SELECT b FROM Bonds b WHERE b.percentage = :percentage")
    , @NamedQuery(name = "Bonds.findByAvailability", query = "SELECT b FROM Bonds b WHERE b.availability = :availability")})
public class Bonds implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bondID")
    private Integer bondID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expirationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "percentage")
    private int percentage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "availability")
    private int availability;

    public Bonds() {
    }

    public Bonds(Integer bondID) {
        this.bondID = bondID;
    }

    public Bonds(Integer bondID, Date expirationDate, int percentage, int availability) {
        this.bondID = bondID;
        this.expirationDate = expirationDate;
        this.percentage = percentage;
        this.availability = availability;
    }

    public Integer getBondID() {
        return bondID;
    }

    public void setBondID(Integer bondID) {
        this.bondID = bondID;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bondID != null ? bondID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bonds)) {
            return false;
        }
        Bonds other = (Bonds) object;
        if ((this.bondID == null && other.bondID != null) || (this.bondID != null && !this.bondID.equals(other.bondID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.elbancodelplaza.entity.Bonds[ bondID=" + bondID + " ]";
    }
    
}
