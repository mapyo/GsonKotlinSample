package com.mapyo.gsonkotlinsample

import com.google.gson.Gson
import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class GsonSampleUnitTest {
    @Test
    fun userNonNull() {
        val user = Gson().fromJson(createUserJson(), UserNonNull::class.java)
        assertThat(user.id).isEqualTo(10)
        assertThat(user.name).isEqualTo("hoge")
        assertThat(user.hasFamily).isTrue()
    }

    @Test
    fun userNonNull_Null() {
        val user = Gson().fromJson(createUserNullJson(), UserNonNull::class.java)
        assertThat(user.id).isEqualTo(0)
        assertThat(user.name).isEqualTo(null)
        assertThat(user.hasFamily).isFalse()
    }

    @Test
    fun userNonNull_NoKey() {
        val user = Gson().fromJson(createUserNoKeyJson(), UserNonNull::class.java)
        assertThat(user.id).isEqualTo(0)
        assertThat(user.name).isEqualTo(null)
        assertThat(user.hasFamily).isFalse()
    }

    @Test
    fun userNullable() {
        val user = Gson().fromJson(createUserJson(), UserNullable::class.java)
        assertThat(user.id).isEqualTo(10)
        assertThat(user.name).isEqualTo("hoge")
        assertThat(user.hasFamily).isTrue()
    }

    @Test
    fun userNullable_Null() {
        val user = Gson().fromJson(createUserNullJson(), UserNullable::class.java)
        assertThat(user.id).isNull()
        assertThat(user.name).isNull()
        assertThat(user.hasFamily).isNull()
    }

    @Test
    fun userNullable_NoKey() {
        val user = Gson().fromJson(createUserNoKeyJson(), UserNullable::class.java)
        assertThat(user.id).isNull()
        assertThat(user.name).isNull()
        assertThat(user.hasFamily).isNull()
    }

    fun createUserJson(): String {
        return """
{
  "id": 10,
  "name": "hoge",
  "has_family": true
}
"""
    }

    fun createUserNullJson(): String {
        return """
{
  "id": null,
  "name": null,
  "has_family": null
}
"""
    }

    fun createUserNoKeyJson(): String {
        return """
{
}
"""
    }
}
