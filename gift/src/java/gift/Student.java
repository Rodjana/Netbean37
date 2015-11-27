/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gift;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author TMN
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findByStuID", query = "SELECT s FROM Student s WHERE s.stuID = :stuID"),
    @NamedQuery(name = "Student.findByStuName", query = "SELECT s FROM Student s WHERE s.stuName = :stuName"),
    @NamedQuery(name = "Student.findByStuEmail", query = "SELECT s FROM Student s WHERE s.stuEmail = :stuEmail"),
    @NamedQuery(name = "Student.findByStuTel", query = "SELECT s FROM Student s WHERE s.stuTel = :stuTel"),
    @NamedQuery(name = "Student.findByStuBirthday", query = "SELECT s FROM Student s WHERE s.stuBirthday = :stuBirthday")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Stu_ID")
    private Integer stuID;
    @Size(max = 40)
    @Column(name = "Stu_Name")
    private String stuName;
    @Size(max = 40)
    @Column(name = "Stu_E-mail")
    private String stuEmail;
    @Size(max = 40)
    @Column(name = "Stu_Tel")
    private String stuTel;
    @Size(max = 40)
    @Column(name = "Stu_Birthday")
    private String stuBirthday;
    @JoinColumn(name = "Adv_ID", referencedColumnName = "Adv_ID")
    @ManyToOne
    private Advisor advID;
    @JoinColumn(name = "Fac_ID", referencedColumnName = "Fac_ID")
    @ManyToOne
    private Faculty facID;
    @JoinColumn(name = "Maj_ID", referencedColumnName = "Maj_ID")
    @ManyToOne
    private Major majID;
    @JoinColumn(name = "Cou_ID", referencedColumnName = "Cou_ID")
    @ManyToOne
    private Subject couID;

    public Student() {
    }

    public Student(Integer stuID) {
        this.stuID = stuID;
    }

    public Integer getStuID() {
        return stuID;
    }

    public void setStuID(Integer stuID) {
        this.stuID = stuID;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public String getStuTel() {
        return stuTel;
    }

    public void setStuTel(String stuTel) {
        this.stuTel = stuTel;
    }

    public String getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(String stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public Advisor getAdvID() {
        return advID;
    }

    public void setAdvID(Advisor advID) {
        this.advID = advID;
    }

    public Faculty getFacID() {
        return facID;
    }

    public void setFacID(Faculty facID) {
        this.facID = facID;
    }

    public Major getMajID() {
        return majID;
    }

    public void setMajID(Major majID) {
        this.majID = majID;
    }

    public Subject getCouID() {
        return couID;
    }

    public void setCouID(Subject couID) {
        this.couID = couID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stuID != null ? stuID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.stuID == null && other.stuID != null) || (this.stuID != null && !this.stuID.equals(other.stuID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gift.Student[ stuID=" + stuID + " ]";
    }
    
}
