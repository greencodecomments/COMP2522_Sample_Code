package ca.bcit.comp2522.labs.streams;

import java.time.Period;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.Objects;

public class Student {

    public enum Specialty {
        PROGRAMMING,
        DESIGN,
        PROJECT_MANAGEMENT,
        WEB_DEVELOPMENT,
        SYSTEMS_ADMIN,
        DATABASE,
        QUALITY_ASSURANCE
    }

    private String first_name;
    private String last_name;
    private String student_id;
    private LocalDate birth_date;
    private Specialty specialty;

    public Student(String first_name, String last_name, String student_id, LocalDate birth_date, Specialty specialty) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.student_id = student_id;
        this.birth_date = birth_date;
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", student_id='" + student_id + '\'' +
                ", birth_date=" + birth_date +
                ", specialty=" + specialty +
                "}\n";
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public int getAge() {
        return Period.between(birth_date, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return first_name.equals(student.first_name) &&
                last_name.equals(student.last_name) &&
                student_id.equals(student.student_id) &&
                birth_date.equals(student.birth_date) &&
                specialty == student.specialty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, student_id, birth_date, specialty);
    }

    public static class firstNameAscComparator implements Comparator<Student> {
        //if this is smaller, return negative
        @Override
        public int compare(Student o1, Student o2) {
            return o1.first_name.compareTo(o2.first_name);
        }
    }

    public static class lastNameDescComparator implements Comparator<Student> {
        //if this is smaller, return negative
        @Override
        public int compare(Student o1, Student o2) {
            //return o1.last_name.compareTo(o2.last_name); //Asc
            return o2.last_name.compareTo(o1.last_name); //Desc
        }
    }

}
