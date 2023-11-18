import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class CalculateLeave {
    String employeeType;
    String joiningDate;
    int sickLeave;
    int vacationLeave;

    CalculateLeave(String employeeType, String joiningDate) {
        this.employeeType = employeeType;
        this.joiningDate = joiningDate;
    }

    public Employee calculateLeave() {

        double vacationLeaveDouble;
        double sickLeaveDouble;

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate startDate = LocalDate.parse(joiningDate, format);
        int year = startDate.getYear();
        LocalDate endDate = LocalDate.of(year, 12, 31);

        Period period = Period.between(startDate, endDate);
        int totalDays = (period.getDays() + period.getMonths() * 30 + period.getYears() * 365) + 1;

        boolean isLeapYear;
        isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        int daysInYear;
        if(isLeapYear) {
            daysInYear = 366;
        }
        else {
            daysInYear = 365;
        }

        if(employeeType.equalsIgnoreCase("officer")) {
            vacationLeaveDouble = (double) (totalDays * 15) / daysInYear;
            if (vacationLeaveDouble < 0.5) {
                vacationLeave = (int) Math.floor(vacationLeaveDouble);
            } else {
                vacationLeave = (int) Math.ceil(vacationLeaveDouble);
            }

            sickLeaveDouble = (double) (totalDays * 10) / daysInYear;
            if (sickLeaveDouble < 0.5) {
                sickLeave = (int) Math.floor(sickLeaveDouble);
            } else {
                sickLeave = (int) Math.ceil(sickLeaveDouble);
            }
            return new Employee(vacationLeave, sickLeave);
        } else if (employeeType.equalsIgnoreCase("Staff")) {
            vacationLeaveDouble = (double) (totalDays * 10) / daysInYear;
            if (vacationLeaveDouble < 0.5) {
                vacationLeave = (int) Math.floor(vacationLeaveDouble);
            } else {
                vacationLeave = (int) Math.ceil(vacationLeaveDouble);
            }

            sickLeaveDouble = (double) (totalDays * 7) / daysInYear;
            if (sickLeaveDouble < 0.5) {
                sickLeave = (int) Math.floor(sickLeaveDouble);
            } else {
                sickLeave = (int) Math.ceil(sickLeaveDouble);
            }
            return new Employee(vacationLeave, sickLeave);
        } else {
            return new Employee(0, 0);
        }
    }
}
