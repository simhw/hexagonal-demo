package com.example.demo.account.adapter.out.persistence

import com.example.demo.account.application.port.out.LoadAccountPort
import com.example.demo.account.application.port.out.UpdateAccountPort
import com.example.demo.account.domain.model.Account
import org.springframework.stereotype.Repository

@Repository
class AccountPersistenceAdapter(
    val accountJpaRepository: AccountJpaRepository,
    val accountMapper: AccountMapper
) : LoadAccountPort, UpdateAccountPort {

    override fun loadAccount(accountId: Long): Account {
        val accountEntity = accountJpaRepository.findById(accountId)
            .orElseThrow { IllegalArgumentException("not found account") }
        return accountMapper.toAccount(accountEntity)
    }

    override fun updateAccount(account: Account) {
        val accountEntity = accountMapper.toAccountEntity(account)
        accountJpaRepository.save(accountEntity)
    }
}