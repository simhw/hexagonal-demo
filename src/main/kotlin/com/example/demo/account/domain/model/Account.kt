package com.example.demo.account.domain.model

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

@NoArgsConstructor
@AllArgsConstructor
class Account(
    var id: Long,
    var balance: Double = 0.0
) {
    fun withdraw(amount: Double) {
        if (amount > balance) {
            throw IllegalArgumentException("잔고 부족")
        }
        balance -= amount
    }

    fun deposit(amount: Double) {
        if (amount < 0) {
            throw IllegalArgumentException("금액 이상")
        }
        balance += amount
    }
}