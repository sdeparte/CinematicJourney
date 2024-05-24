package com.wizbii.cinematic.journey.domain.entity

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class TmdbPersonId(val value: Int) {

    override fun toString() = value.toString()

}
