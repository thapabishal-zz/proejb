package org.proejb.inf.dto;

import javax.xml.bind.annotation.XmlRootElement;
import java.beans.Transient;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@XmlRootElement
public class UserDto implements Serializable {

    String firstName;
    String lastName;
    double age;
    LocalDate dateOfBirth;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Transient
    public String getName() {
        return this.getFirstName()+ " "+this.getLastName();
    }
}
