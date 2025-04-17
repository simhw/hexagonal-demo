package com.example.demo.account.adapter.out.persistence

import com.example.demo.account.domain.model.Account
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface AccountMapper {
    fun toAccountEntity(account: Account): AccountEntity
    fun toAccount(accountEntity: AccountEntity): Account
}