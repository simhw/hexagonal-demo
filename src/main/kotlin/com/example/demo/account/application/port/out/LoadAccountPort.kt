package com.example.demo.account.application.port.out

import com.example.demo.account.domain.model.Account


interface LoadAccountPort {
    fun loadAccount(accountId: Long): Account
}