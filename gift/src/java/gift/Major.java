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
@Table(name = "major")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Major.findAll", query = "SELECT m FROM Major m"),
    @NamedQuery(name = "Major.findByMajID", query = "SELECT m FROM Major m WHERE m.majID = :majID"),
    @NamedQuery(name = "Major.findByMajName", query = "SELECT m FROM Major m WHERE m.majName = :majName")})
public class Major implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Maj_ID")
    private Integer majID;
    @Size(max = 40)
    @Column(name = "Maj_Name")
    private String majName;
    @OneToMany(mappedBy = "majID")
    private Collection<Student> studentCollection;

    public Major() {
    }

    public Major(Integer majID) {
        this.majID = majID;
    }

    public Integer getMajID() {
        return majID;
    }

    public void setMajID(Integer majID) {
        this.majID = majID;
    }

    public String getMajName() {
        return majName;
    }

    public void setMajName(String majName) {
        this.majName = majName;
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (majID != null ? majID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Major)) {
            return false;
        }
        Major other = (Major) object;
        if ((this.majID == null && other.majID != null) || (this.majID != null && !this.majID.equals(other.majID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gift.Major[ majID=" + majID + " ]";
    }
    
}
