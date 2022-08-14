package bd.edu.rifat.exam.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbl_blood")
public class Blood implements Serializable {


    public static final String MALE = "MALE";
    public static final String FEMALE = "FEMALE";

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "age")
    private double age;
    @ColumnInfo(name = "phone")
    private String phone;
    @ColumnInfo(name = "gender")
    private String gender;
    @ColumnInfo(name = "bloodGroup")
    private String bloodGroup;

    @Ignore
    public Blood(int id, String name, double age, String phone, String gender, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
    }

    @Ignore
    public Blood(String name, double age, String phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Blood(String name, double age, String phone, String gender, String bloodGroup) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
