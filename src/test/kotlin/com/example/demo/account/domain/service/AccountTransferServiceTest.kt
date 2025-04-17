package com.example.demo.account.domain.service

import com.example.demo.account.application.port.`in`.AccountTransferCommand
import com.example.demo.account.application.port.out.LoadAccountPort
import com.example.demo.account.application.port.out.UpdateAccountPort
import com.example.demo.account.domain.model.Account
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach

class AccountTransferServiceTest() {

    private val loadAccountPort = mockk<LoadAccountPort>()
    private val updateAccountPort = mockk<UpdateAccountPort>(relaxed = true)

    private lateinit var accountTransferService: AccountTransferService

    @BeforeEach
    fun setup() {
        accountTransferService = AccountTransferService(loadAccountPort, updateAccountPort)
    }

    @Test
    fun transfer() {
        @Test
        fun `계좌 이체 테스트`() {
            // given
            val sourceAccount = mockk<Account>(relaxed = true)
            val targetAccount = mockk<Account>(relaxed = true)

            every { loadAccountPort.loadAccount(1L) } returns sourceAccount
            every { loadAccountPort.loadAccount(2L) } returns targetAccount

            val command = AccountTransferCommand(
                sourceAccountId = 1L,
                targetAccountId = 2L,
                amount = 100.0
            )

            // when
            accountTransferService.transfer(command)

            // then
            verify { sourceAccount.withdraw(100.0) }
            verify { targetAccount.deposit(100.0) }
            verify { updateAccountPort.updateAccount(sourceAccount) }
            verify { updateAccountPort.updateAccount(targetAccount) }

        }
    }
}