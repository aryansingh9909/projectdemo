package guru.springframework.commands;

import java.math.BigDecimal;

/**
 * Created by jt on 1/10/17.
 */
public class PatientForm {
    private String id;
    private String Name;
    private BigDecimal Age;
    private String Gender;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public BigDecimal getAge() {
        return Age;
    }

    public void setAge(BigDecimal Age) {
        this.Age = Age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }
}
