package com.korugan.cleanarchitecture.data.remote.dto

data class Result(
    val changeDay: Double,
    val changeDaystr: String,
    val changeHour: Double,
    val changeHourstr: String,
    val changeWeek: Double,
    val changeWeekstr: String,
    val circulatingSupply: String,
    val code: String,
    val currency: String,
    val marketCap: Long,
    val marketCapstr: String,
    val name: String,
    val price: Double,
    val pricestr: String,
    val volume: Long,
    val volumestr: String
)