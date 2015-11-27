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
@Table(name = "advisor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advisor.findAll", query = "SELECT a FROM Advisor a"),
    @NamedQuery(name = "Advisor.findByAdvID", query = "SELECT a FROM Advisor a WHERE a.advID = :advID"),
    @NamedQuery(name = "Advisor.findByAdvName", query = "SELECT a FROM Advisor a WHERE a.advName = :advName")})
public class Advisor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Adv_ID")
    private Integer advID;
    @Size(max = 40)
    @Column(name = "Adv_Name")
    private String advName;
    @OneToMany(mappedBy = "advID")
    private Collection<Student> studentCollection;
    @OneToMany(mappedBy = "advID")
    private Collection<Subject> subjectCollection;

    public Advisor() {
    }

    public Advisor(Integer advID) {
        this.advID = advID;
    }

    public Integer getAdvID() {
        return advID;
    }

    public void setAdvID(Integer advID) {
        this.advID = advID;
    }

    public String getAdvName() {
        return advName;
    }

    public void setAdvName(String advName) {
        this.advName = advName;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @XmlTransient
    public Collection<Subject> getSubjectCollection() {
        return subjectCollection;
    }

    public void setSubjectCollection(Collection<Subject> subjectCollection) {
        this.subjectCollection = subjectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (advID != null ? advID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Advisor)) {
            return false;
        }
        Advisor other = (Advisor) object;
        if ((this.advID == null && other.advID != null) || (this.advID != null && !this.advID.equals(other.advID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gift.Advisor[ advID=" + advID + " ]";
    }
    
}
