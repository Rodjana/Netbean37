/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gift;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TMN
 */
@Entity
@Table(name = "subject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s"),
    @NamedQuery(name = "Subject.findByCouID", query = "SELECT s FROM Subject s WHERE s.couID = :couID"),
    @NamedQuery(name = "Subject.findByCouName", query = "SELECT s FROM Subject s WHERE s.couName = :couName"),
    @NamedQuery(name = "Subject.findByCouID1", query = "SELECT s FROM Subject s WHERE s.couID1 = :couID1")})
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cou_ID")
    private Integer couID;
    @Size(max = 40)
    @Column(name = "Cou_Name")
    private String couName;
    @Column(name = "Cou_ID1")
    private Integer couID1;
    @OneToMany(mappedBy = "couID")
    private Collection<Student> studentCollection;
    @JoinColumn(name = "Adv_ID", referencedColumnName = "Adv_ID")
    @ManyToOne
    private Advisor advID;

    public Subject() {
    }

    public Subject(Integer couID) {
        this.couID = couID;
    }

    public Integer getCouID() {
        return couID;
    }

    public void setCouID(Integer couID) {
        this.couID = couID;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public Integer getCouID1() {
        return couID1;
    }

    public void setCouID1(Integer couID1) {
        this.couID1 = couID1;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    public Advisor getAdvID() {
        return advID;
    }

    public void setAdvID(Advisor advID) {
        this.advID = advID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (couID != null ? couID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.couID == null && other.couID != null) || (this.couID != null && !this.couID.equals(other.couID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gift.Subject[ couID=" + couID + " ]";
    }
    
}
