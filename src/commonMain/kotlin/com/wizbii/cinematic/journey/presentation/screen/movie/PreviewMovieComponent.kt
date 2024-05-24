package com.wizbii.cinematic.journey.presentation.screen.movie

import com.wizbii.cinematic.journey.domain.entity.*
import com.wizbii.cinematic.journey.presentation.component.top.bar.PreviewTopBarComponent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.datetime.LocalDate
import kotlin.random.Random

class PreviewMovieComponent : MovieComponent {

    override val cast = MutableStateFlow(
        List(5) { index ->
            TmdbCast(
                character = "Robert D. Jr. / Iron Man",
                tmdbMovieId = TmdbMovieId(index),
                name = "Robert D. Jr.",
                tmdbPersonId = TmdbPersonId(index),
                profileImgPath = null,
            )
        }
    )

    override val movie = MutableStateFlow(
        Movie(
            backdropPath = null,
            id = MovieId("id"),
            overview = "Harley Quinn joins forces with a singer, an assassin and a police detective to help a young girl who had a hit placed on her after she stole a rare diamond from a crime lord.",
            posterPath = null,
            prerequisitesIds = List(5) { index ->
                MovieId(index.toString())
            }.toSet(),
            releaseDate = LocalDate.parse("2020-05-02"),
            runtime = 109,
            score = 3.1415927f,
            tagline = "Mind Over Mayhem",
            title = "Birds of Prey (and the Fantabulous Emancipation of One Harley Quinn)",
            tmdbId = TmdbMovieId(495764),
            universeId = UniverseId("mcu"),
            watched = false,
        )
    )

    override val prerequisites = MutableStateFlow(
        List(5) { index ->
            Movie(
                backdropPath = null,
                id = MovieId(index.toString()),
                overview = null,
                posterPath = null,
                prerequisitesIds = emptySet(),
                releaseDate = LocalDate.parse("2008-04-30"),
                runtime = null,
                score = null,
                tagline = null,
                title = "Iron Man",
                tmdbId = TmdbMovieId(-1),
                universeId = UniverseId("mcu"),
                watched = Random(index).nextBoolean(),
            )
        }
    )

    override val topBarComponent = PreviewTopBarComponent(true)

    override fun backdropUrl(backdropPath: String?, width: Int) = MutableStateFlow(null)

    override fun onMovieClicked(movieId: MovieId) = Unit

    override fun posterUrl(posterPath: String?, width: Int) = MutableStateFlow(null)

    override fun setMovieWatched(movieId: MovieId, watched: Boolean) = Unit

}
