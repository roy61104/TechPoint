package com.roy.techpoint.annotation.kotlin

object BankService {
    @BankTransferMoney(maxMoney = 15000.00)
    fun transferMoney(money: Double) {
        println(processAnnotationMoney(money))
    }

    private fun processAnnotationMoney(money: Double): String {
        try {
            val transferMoney = BankService::class.java.getDeclaredMethod(
                "transferMoney",
                Double::class.javaPrimitiveType
            )
            val annotationPresent = transferMoney.isAnnotationPresent(BankTransferMoney::class.java)
            if (annotationPresent) {
                val annotation = transferMoney.getAnnotation(
                    BankTransferMoney::class.java
                )
                val maxMoney = annotation.maxMoney
                return if (money > maxMoney) {
                    "转账金额大于限额，转账失败"
                } else {
                    "转账金额为:$money，转账成功"
                }
            }
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        }
        return "转账处理失败"
    }

    @JvmStatic
    fun main(args: Array<String>) {
        transferMoney(10000.0)
    }
}