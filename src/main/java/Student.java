public class Student {
    private String name;
    private int age;
    private String birthDate;

    public Student(String name, int age, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "imię='" + name + '\'' +
                ", wiek=" + age +
                ", data urodzenia='" + birthDate + '\'' +
                '}';
    }
}
