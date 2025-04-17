package com.example.demo.account.application.port.`in`

data class AccountTransferCommand(
    val sourceAccountId: Long,
    val targetAccountId: Long,
    val amount: Double
)