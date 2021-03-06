package entity;

import java.util.Date;

public class Student{
 private String id;
 private String name;
 private Date birthday;
 private String description;//备注
 private int avgscore;

 public Student(){}

    public Student(String id, String name, Date birthday, String description, int avgscore) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.description = description;
        this.avgscore = avgscore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(int avgscore) {
        this.avgscore = avgscore;
    }


}


