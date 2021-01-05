public class Worker {
    private final String name, surname;
    private float salary;

    public Worker(String name, String surname, float salary) {
    this.name = name;
    this.surname = surname;
    this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary=salary;
    }

}
