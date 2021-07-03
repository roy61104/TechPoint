package com.roy.techpoint.annotation.java;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 假设银行有个转账业务，转账的限额可能会根据汇率的变化而变化，我们可以利用注解灵活配置转账的限额，而不用每次都去修改我们的业务代码。
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BankTransferMoney {
    double maxMoney() default 10000;
}
