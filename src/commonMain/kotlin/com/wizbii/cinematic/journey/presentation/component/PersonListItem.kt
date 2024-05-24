package com.wizbii.cinematic.journey.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.Flow

private const val profileImgAspectRatio = 2 / 3f

@Composable
fun PersonListItem(
    modifier: Modifier = Modifier,
    personCharacter: String?,
    personName: String?,
    personProfileImgPath: String?,
    profileImgHeight: Dp = 120.dp,
    posterUrlBuilder: (String?, Int) -> Flow<String?>,
) {

    val profileImgWidth = profileImgHeight * profileImgAspectRatio
    val profileImgWidthPx = with(LocalDensity.current) { profileImgWidth.roundToPx() }
    val profileImgUrl by posterUrlBuilder(personProfileImgPath, profileImgWidthPx).collectAsState(null)

    PersonListItem(
        modifier = modifier,
        personCharacter = personCharacter,
        personName = personName,
        profileImgHeight = profileImgHeight,
        profileImgWidth = profileImgWidth,
        profileImgUrl = profileImgUrl,
    )

}

@Composable
private fun PersonListItem(
    modifier: Modifier = Modifier,
    personCharacter: String?,
    personName: String?,
    profileImgHeight: Dp,
    profileImgWidth: Dp,
    profileImgUrl: String?,
) {

    ElevatedCard(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        modifier = modifier
            .width(profileImgWidth)
            .fillMaxHeight(),
        shape = RoundedCornerShape(4.dp),
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {

            RemoteImage(
                contentDescription = null, // TODO
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(profileImgHeight)
                    .aspectRatio(profileImgAspectRatio)
                    .background(MaterialTheme.colorScheme.surfaceColorAtElevation(16.dp)),
                url = profileImgUrl,
            )

            Column(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
            ) {

                AutoSizeText(
                    maxLines = 1,
                    minScale = .9,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.SemiBold),
                    text = personName ?: "",
                )

                AutoSizeText(
                    maxLines = 1,
                    minScale = .9,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodyMedium,
                    text = personCharacter ?: "",
                )

            }

        }

    }

}
