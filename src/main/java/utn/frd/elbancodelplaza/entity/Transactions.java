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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pmari
 */
@Entity
@Table(name = "transactions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transactions.findAll", query = "SELECT t FROM Transactions t")
    , @NamedQuery(name = "Transactions.findByTransactionID", query = "SELECT t FROM Transactions t WHERE t.transactionID = :transactionID")
    , @NamedQuery(name = "Transactions.findByAmount", query = "SELECT t FROM Transactions t WHERE t.amount = :amount")
    , @NamedQuery(name = "Transactions.findByType", query = "SELECT t FROM Transactions t WHERE t.type = :type")
    , @NamedQuery(name = "Transactions.findByStatus", query = "SELECT t FROM Transactions t WHERE t.status = :status")
    , @NamedQuery(name = "Transactions.findByTimeCreated", query = "SELECT t FROM Transactions t WHERE t.timeCreated = :timeCreated")
    , @NamedQuery(name = "Transactions.findByTimeUpdated", query = "SELECT t FROM Transactions t WHERE t.timeUpdated = :timeUpdated")})
public class Transactions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "transactionID")
    private Integer transactionID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timeCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeCreated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timeUpdated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeUpdated;
    @JoinColumn(name = "receiverID", referencedColumnName = "clientID")
    @ManyToOne(optional = false)
    private Clients receiverID;
    @JoinColumn(name = "senderID", referencedColumnName = "clientID")
    @ManyToOne(optional = false)
    private Clients senderID;

    public Transactions() {
    }

    public Transactions(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public Transactions(Integer transactionID, int amount, String type, int status, Date timeCreated, Date timeUpdated) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.type = type;
        this.status = status;
        this.timeCreated = timeCreated;
        this.timeUpdated = timeUpdated;
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Integer transactionID) {
        this.transactionID = transactionID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Date timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public Clients getReceiverID() {
        return receiverID;
    }

    public void setReceiverID(Clients receiverID) {
        this.receiverID = receiverID;
    }

    public Clients getSenderID() {
        return senderID;
    }

    public void setSenderID(Clients senderID) {
        this.senderID = senderID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionID != null ? transactionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transactions)) {
            return false;
        }
        Transactions other = (Transactions) object;
        if ((this.transactionID == null && other.transactionID != null) || (this.transactionID != null && !this.transactionID.equals(other.transactionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.elbancodelplaza.entity.Transactions[ transactionID=" + transactionID + " ]";
    }
    
}
