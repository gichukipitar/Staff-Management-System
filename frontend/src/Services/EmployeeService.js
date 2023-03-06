import axios from 'axios';

const EMPLOYEE_BASE_URL = "http://localhost:8080/employeemanagamentsystem/employee/listall"

class EmployeeService {
    getEmployees() {
        return axios.get(EMPLOYEE_BASE_URL);
    }

    createEmployee(employee) {
        return axios.post(EMPLOYEE_BASE_URL, employee);
    }


}

export default new EmployeeService()