package com.wizbii.cinematic.journey.domain.use.case

import com.wizbii.cinematic.journey.domain.entity.TmdbCast
import com.wizbii.cinematic.journey.domain.entity.TmdbMovieId
import com.wizbii.cinematic.journey.domain.repository.TmdbRepository
import kotlinx.coroutines.flow.Flow

class ObserveCastForMovieUseCase(
    private val tmdbRepository: TmdbRepository,
) {

    operator fun invoke(tmdbMovieId: TmdbMovieId, language: String): Flow<List<TmdbCast>> =
        tmdbRepository.getLocalTmdbMovieCast(tmdbMovieId, language)

}
