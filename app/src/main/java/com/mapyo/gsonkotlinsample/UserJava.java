package com.mapyo.gsonkotlinsample;


import com.google.gson.annotations.SerializedName;

public class UserJava {
    public Integer id;

    public String name;

    @SerializedName("has_family")
    public Boolean hasFamily;
}
