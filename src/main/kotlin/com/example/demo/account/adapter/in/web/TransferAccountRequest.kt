package com.example.demo.account.adapter.`in`.web

import com.example.demo.account.application.port.`in`.AccountTransferCommand

data class TransferAccountRequest(
    val sourceAccountId: Long,
    val targetAccountId: Long,
    val amount: Double
) {
    companion object {
        fun from(request: TransferAccountRequest): AccountTransferCommand {
            return AccountTransferCommand(
                request.sourceAccountId,
                request.targetAccountId,
                request.amount
            )
        }
    }
}