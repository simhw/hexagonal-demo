package com.example.demo.account.domain.service

import com.example.demo.account.application.port.`in`.AccountTransferCommand
import com.example.demo.account.application.port.`in`.AccountTransferUseCase
import com.example.demo.account.application.port.out.LoadAccountPort
import com.example.demo.account.application.port.out.UpdateAccountPort
import jakarta.transaction.Transactional

import org.springframework.stereotype.Service

@Service
class AccountTransferService(
    private val loadAccountPort: LoadAccountPort,
    private val updateAccountPort: UpdateAccountPort
) : AccountTransferUseCase {
    @Transactional
    override fun transfer(command: AccountTransferCommand) {
        val sourceAccount = loadAccountPort.loadAccount(command.sourceAccountId)
        val targetAccount = loadAccountPort.loadAccount(command.targetAccountId)

        sourceAccount.withdraw(command.amount)
        targetAccount.deposit(command.amount)

        updateAccountPort.updateAccount(sourceAccount)
        updateAccountPort.updateAccount(targetAccount)
    }
}
