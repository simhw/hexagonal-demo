package com.example.demo.account.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface AccountJpaRepository: JpaRepository<AccountEntity, Long> {
}