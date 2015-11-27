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
@Table(name = "faculty")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Faculty.findAll", query = "SELECT f FROM Faculty f"),
    @NamedQuery(name = "Faculty.findByFacID", query = "SELECT f FROM Faculty f WHERE f.facID = :facID"),
    @NamedQuery(name = "Faculty.findByFacName", query = "SELECT f FROM Faculty f WHERE f.facName = :facName")})
public class Faculty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fac_ID")
    private Integer facID;
    @Size(max = 40)
    @Column(name = "Fac_Name")
    private String facName;
    @OneToMany(mappedBy = "facID")
    private Collection<Student> studentCollection;

    public Faculty() {
    }

    public Faculty(Integer facID) {
        this.facID = facID;
    }

    public Integer getFacID() {
        return facID;
    }

    public void setFacID(Integer facID) {
        this.facID = facID;
    }

    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
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
        hash += (facID != null ? facID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faculty)) {
            return false;
        }
        Faculty other = (Faculty) object;
        if ((this.facID == null && other.facID != null) || (this.facID != null && !this.facID.equals(other.facID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gift.Faculty[ facID=" + facID + " ]";
    }
    
}
