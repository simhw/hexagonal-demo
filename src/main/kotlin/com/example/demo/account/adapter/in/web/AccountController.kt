package com.example.demo.account.adapter.`in`.web

import com.example.demo.account.application.port.`in`.AccountTransferUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/accounts")
class AccountController(
    val accountTransferUseCase: AccountTransferUseCase
) {
    @PostMapping("/transfer")
    fun update(request: TransferAccountRequest) {
        accountTransferUseCase.transfer(TransferAccountRequest.from(request))
    }
}
