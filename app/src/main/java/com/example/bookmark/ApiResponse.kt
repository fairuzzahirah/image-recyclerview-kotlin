package com.example.bookmark

data class ApiResponse(
    val info: Info,
    val data: List<MainModel>
)

data class Info(
    val count: Int,
    val totalPages: Int,
    val previousPage: String?,
    val nextPage: String?
)
