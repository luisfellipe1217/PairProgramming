package model;

import java.math.BigDecimal;
import java.util.Objects;

public class User {

    private Integer id;
    private String name;
    private String function;
    private BigDecimal salary;

    public User() {
    }

    public User(Integer id, String name, String function, BigDecimal salary) {
        this.id = id;
        setId(this.id);
        this.name = name;
        setName(this.name);
        this.function = function;
        setFunction(this.function);
        this.salary = salary;
        setSalary(this.salary);
    }

    public Integer getId() {
        if (Objects.nonNull(id))
            return id;
        return -1;
    }

    public void setId(Integer id) {
        if (Objects.nonNull(id))
            this.id = id;
    }

    public String getName() {
        if (Objects.nonNull(name))
            return name;
        return "";
    }

    public void setName(String name) {
        if (Objects.nonNull(name))
            this.name = name;
    }

    public String getFunction() {
        if (Objects.nonNull(function))
            return function;
        return "";
    }

    public void setFunction(String function) {
        if (Objects.nonNull(function))
            this.function = function;
    }

    public BigDecimal getSalary() {
        if (Objects.nonNull(salary))
            return salary;
        return BigDecimal.ZERO;
    }

    public void setSalary(BigDecimal salary) {
        if (Objects.nonNull(salary))
            this.salary = salary;
    }

    public void setSalary(Double salary) {
        if (Objects.nonNull(salary))
            setSalary(new BigDecimal(salary));
    }
}
