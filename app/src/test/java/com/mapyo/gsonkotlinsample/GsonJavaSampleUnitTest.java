package com.mapyo.gsonkotlinsample;

import com.google.gson.Gson;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class GsonJavaSampleUnitTest {
    @Test
    public void user() {
        UserJava user = new Gson().fromJson(createUserJson(), UserJava.class);
        assertThat(user.id).isEqualTo(10);
        assertThat(user.name).isEqualTo("hoge");
        assertThat(user.hasFamily).isTrue();
    }

    @Test
    public void user_Null() {
        UserJava user = new Gson().fromJson(createUserNullJson(), UserJava.class);
        assertThat(user.id).isNull();
        assertThat(user.name).isNull();
        assertThat(user.hasFamily).isNull();
    }

    @Test
    public void user_NoKey() {
        UserJava user = new Gson().fromJson(createUserNoKeyJson(), UserJava.class);
        assertThat(user.id).isNull();
        assertThat(user.name).isNull();
        assertThat(user.hasFamily).isNull();
    }

    public String createUserJson() {
        return " {"
                +  "\"id\": 10, "
                +  "\"name\": \"hoge\", "
                +  "\"has_family\": true "
                + "}";
    }

    public String createUserNullJson() {
        return " {"
              +  "\"id\": null, "
              +  "\"name\": null, "
              +  "\"has_family\": null "
              + "}";
    }

    public String createUserNoKeyJson() {
        return " { } ";
    }
}
