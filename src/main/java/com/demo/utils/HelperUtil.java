package com.demo.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.demo.model.Employee;

public class HelperUtil {

    private HelperUtil() {
    }

    public static Supplier<List<Employee>> employeeSupplier = () ->
            Arrays.asList(
		            Employee.builder().empId(1).firstName("Binay").lastName("Gurung").salary(3000.0f).build()
			);


}
