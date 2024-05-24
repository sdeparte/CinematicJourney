package com.wizbii.cinematic.journey.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class TmdbCast(
    val character: String?,
    val tmdbMovieId: TmdbMovieId,
    val name: String?,
    val tmdbPersonId: TmdbPersonId,
    val profileImgPath: String?,
) {

}
