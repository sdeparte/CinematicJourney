package com.wizbii.cinematic.journey.domain.repository

import com.wizbii.cinematic.journey.domain.entity.TmdbCast
import com.wizbii.cinematic.journey.domain.entity.TmdbMovie
import com.wizbii.cinematic.journey.domain.entity.TmdbMovieId
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.Instant

interface TmdbRepository {

    suspend fun cleanupOldTmdbMovies(olderThan: Instant)

    suspend fun getTmdbBackdropUrlForWidth(backdropPath: String, width: Int): String

    suspend fun getLocalTmdbMovie(
        id: TmdbMovieId,
        language: String,
        maxFetchDate: Instant = Instant.DISTANT_PAST,
    ): Flow<TmdbMovie?>

    suspend fun getRemoteTmdbMovie(id: TmdbMovieId, language: String): TmdbMovie

    fun getLocalTmdbMovieCast(
        id: TmdbMovieId,
        language: String,
        maxFetchDate: Instant = Instant.DISTANT_PAST,
    ): Flow<List<TmdbCast>>

    suspend fun getRemoteTmdbMovieCast(id: TmdbMovieId, language: String): List<TmdbCast>

    suspend fun getTmdbPosterUrlForWidth(posterPath: String, width: Int): String

    suspend fun setLocalTmdbMovie(tmdbMovie: TmdbMovie, fetchDate: Instant, language: String)

    suspend fun setLocalTmdbMovieCast(tmdbMovieCast: List<TmdbCast>, fetchDate: Instant, language: String)

}
