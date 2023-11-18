import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class FirstServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getParameter("COMMAND") != null) {
            if (request.getParameter("COMMAND").equals("UPDATE_PAGE")) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("employeeUpdate.jsp");
                request.setAttribute("employeeList", new Employee(Integer.parseInt(request.getParameter("id")), request.getParameter("name"), request.getParameter("joiningDate"), request.getParameter("employeeType")));
                requestDispatcher.forward(request, response);
                response.sendRedirect("employeeUpdate.jsp");
            } else if (request.getParameter("COMMAND").equals("UPDATE")) {
                Employee employeeList = new Employee(Integer.parseInt(request.getParameter("id")), request.getParameter("name"), request.getParameter("joiningDate"), request.getParameter("employeeType"));
                DBUtil.update(employeeList);
                response.sendRedirect("first");
            } else if (request.getParameter("COMMAND").equals("DELETE")) {
                int id = Integer.parseInt(request.getParameter("id"));
                DBUtil.delete(id);
                response.sendRedirect("first");
            } else {
                List<Employee> employeeList = DBUtil.getAll();
                request.setAttribute("employeeList", employeeList);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("EmployeeList.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {
            List<Employee> employeeList = DBUtil.getAll();
            request.setAttribute("employeeList", employeeList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("employeeList.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CalculateLeave leaveCalculator = new CalculateLeave(request.getParameter("employeeType"), request.getParameter("joiningDate"));
        Employee calculatedLeave = leaveCalculator.calculateLeave();
        int vacationLeave = calculatedLeave.getVacationLeave();
        int sickLeave = calculatedLeave.getSickLeave();
        Employee employeeList = new Employee(Integer.parseInt(request.getParameter("id")), request.getParameter("name"), request.getParameter("joiningDate"), request.getParameter("employeeType"), vacationLeave, sickLeave);
        DBUtil.create(employeeList);
        response.sendRedirect("first");
    }
}