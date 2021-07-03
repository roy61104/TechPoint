package com.roy.techpoint.annotation.java;

import java.lang.reflect.Method;

public class BankService {

    @BankTransferMoney(maxMoney = 15000)
    public static void TransferMoney(double money) {
          System.out.println(processAnnotationMoney(money));
    }

    private static String processAnnotationMoney(double money) {
        try {
            Method transferMoney = BankService.class.getDeclaredMethod("TransferMoney", double.class);
            boolean annotationPresent = transferMoney.isAnnotationPresent(BankTransferMoney.class);
            if (annotationPresent) {
                BankTransferMoney annotation = transferMoney.getAnnotation(BankTransferMoney.class);
                double maxMoney = annotation.maxMoney();
                if (money > maxMoney) {
                    return "转账金额大于限额，转账失败";
                } else {
                    return "转账金额为:" + money + "，转账成功";
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "转账处理失败";
    }

    public static void main(String[] args) {
        TransferMoney(20000);
    }
}
