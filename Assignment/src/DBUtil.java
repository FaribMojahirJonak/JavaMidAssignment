import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DBUtil {

    static List<Employee> employeeList = new ArrayList<>();

    public static List<Employee> getAll() {
        return employeeList;
    }

    public static void create(Employee p) {
        employeeList.add(new Employee(p.getId(), p.getName(), p.getJoiningDate(), p.getEmployeeType(), p.getVacationLeave(), p.getSickLeave()));
    }

    public static void update(Employee p) {
        employeeList.stream()
                .filter(person -> p.getId() == person.getId())
                .findFirst()
                .ifPresent(person -> {
                    person.setName(p.getName());
                    person.setJoiningDate(p.getJoiningDate());
                    person.setEmployeeType(p.getEmployeeType());
                });
    }

    public static void delete(int id) {
        employeeList = employeeList.stream()
                .filter(person -> id != person.getId())
                .collect(Collectors.toList());
    }
}