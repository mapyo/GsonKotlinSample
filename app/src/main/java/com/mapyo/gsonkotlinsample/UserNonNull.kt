package com.mapyo.gsonkotlinsample

import com.google.gson.annotations.SerializedName


data class UserNonNull(
        val id: Int,
        val name: String,
        @SerializedName("has_family")
        val hasFamily: Boolean
)
