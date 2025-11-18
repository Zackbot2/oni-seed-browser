/*
 * ONI Seed Browser
 * Copyright (C) 2025 Stefan Oltmann
 * https://stefan-oltmann.de
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.time.ExperimentalTime
import ui.theme.DefaultSpacer
import ui.theme.defaultPadding
import ui.theme.lightGray

private val userProfileFontSize = 20.sp

// REQUIREMENTS:
// - clicking a username should bring you to their profile page (unless anonymous)
// - show user position as sticky


@OptIn(ExperimentalTime::class)
@Composable
fun UserProfileView(
    steamIdToUsernameMap: Map<String, String>,
    errorMessage: MutableState<String?>,
    userIdToView : String,
    connectedUserId : String? = null
) {

    val username = steamIdToUsernameMap[userIdToView]?: "Anonymous"

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        DefaultSpacer()

        Text(
            text = username,
            style = MaterialTheme.typography.bodyLarge,
            fontSize = userProfileFontSize,
            color = lightGray,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .defaultPadding()
                .width(800.dp)
        )
    }
}
