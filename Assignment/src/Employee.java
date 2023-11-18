public class Employee {
    private int id;
    private String name;
    private String joiningDate;
    private String employeeType;
    private int vacationLeave;
    private int sickLeave;

    public Employee() {
    }

    public Employee(int vacationLeave, int sickLeave) {
        this.vacationLeave = vacationLeave;
        this.sickLeave = sickLeave;
    }

    public Employee(int id, String name, String joiningDate, String employeeType) {
        this.id = id;
        this.name = name;
        this.joiningDate = joiningDate;
        this.employeeType = employeeType;
    }
    public Employee(int id, String name, String joiningDate, String employeeType, int vacationLeave, int sickLeave) {
        this.id = id;
        this.name = name;
        this.joiningDate = joiningDate;
        this.employeeType = employeeType;
        this.vacationLeave = vacationLeave;
        this.sickLeave = sickLeave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public int getVacationLeave() {
        return vacationLeave;
    }

    public void setVacationLeave(int vacationLeave) {
        this.vacationLeave = vacationLeave;
    }

    public int getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(int sickLeave) {
        this.sickLeave = sickLeave;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", joiningDate='" + joiningDate + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", vacationLeave=" + vacationLeave +
                ", sickLeave=" + sickLeave +
                '}';
    }
}
