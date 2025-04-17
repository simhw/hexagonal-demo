package com.example.demo.account.application.port.`in`

interface AccountTransferUseCase {
    fun transfer(command: AccountTransferCommand)
}