package com.example.demo.account.adapter.out.persistence

import jakarta.persistence.*
import lombok.NoArgsConstructor


@Entity
@Table(name = "accounts")
@NoArgsConstructor
class AccountEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val balance: Double = 0.0
)