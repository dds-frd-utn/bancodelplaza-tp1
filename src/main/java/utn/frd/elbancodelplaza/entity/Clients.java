/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.elbancodelplaza.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pmari
 */
@Entity
@Table(name = "clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c")
    , @NamedQuery(name = "Clients.findByClientID", query = "SELECT c FROM Clients c WHERE c.clientID = :clientID")
    , @NamedQuery(name = "Clients.findByName", query = "SELECT c FROM Clients c WHERE c.name = :name")
    , @NamedQuery(name = "Clients.findByAddress", query = "SELECT c FROM Clients c WHERE c.address = :address")
    , @NamedQuery(name = "Clients.findBySituation", query = "SELECT c FROM Clients c WHERE c.situation = :situation")
    , @NamedQuery(name = "Clients.findByBirthdate", query = "SELECT c FROM Clients c WHERE c.birthdate = :birthdate")
    , @NamedQuery(name = "Clients.findByTel", query = "SELECT c FROM Clients c WHERE c.tel = :tel")
    , @NamedQuery(name = "Clients.findByTimeCreated", query = "SELECT c FROM Clients c WHERE c.timeCreated = :timeCreated")
    , @NamedQuery(name = "Clients.findByTimeUpdated", query = "SELECT c FROM Clients c WHERE c.timeUpdated = :timeUpdated")})
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clientID")
    private Integer clientID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Column(name = "situation")
    private int situation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tel")
    private String tel;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientID")
    private Collection<Accounts> accountsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiverID")
    private Collection<Transactions> transactionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senderID")
    private Collection<Transactions> transactionsCollection1;

    public Clients() {
    }

    public Clients(Integer clientID) {
        this.clientID = clientID;
    }

    public Clients(Integer clientID, String name, String address, int situation, Date birthdate, String tel, Date timeCreated, Date timeUpdated) {
        this.clientID = clientID;
        this.name = name;
        this.address = address;
        this.situation = situation;
        this.birthdate = birthdate;
        this.tel = tel;
        this.timeCreated = timeCreated;
        this.timeUpdated = timeUpdated;
    }

    public Integer getClientID() {
        return clientID;
    }

    public void setClientID(Integer clientID) {
        this.clientID = clientID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSituation() {
        return situation;
    }

    public void setSituation(int situation) {
        this.situation = situation;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    @XmlTransient
    public Collection<Accounts> getAccountsCollection() {
        return accountsCollection;
    }

    public void setAccountsCollection(Collection<Accounts> accountsCollection) {
        this.accountsCollection = accountsCollection;
    }

    @XmlTransient
    public Collection<Transactions> getTransactionsCollection() {
        return transactionsCollection;
    }

    public void setTransactionsCollection(Collection<Transactions> transactionsCollection) {
        this.transactionsCollection = transactionsCollection;
    }

    @XmlTransient
    public Collection<Transactions> getTransactionsCollection1() {
        return transactionsCollection1;
    }

    public void setTransactionsCollection1(Collection<Transactions> transactionsCollection1) {
        this.transactionsCollection1 = transactionsCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientID != null ? clientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.clientID == null && other.clientID != null) || (this.clientID != null && !this.clientID.equals(other.clientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.elbancodelplaza.entity.Clients[ clientID=" + clientID + " ]";
    }
    
}
