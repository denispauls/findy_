package com.example.findy.presentation.maps

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext

@Composable
fun LocationPermissionsAndSettingDialogs(
    updateCurrentLocation: () -> Unit,
) {
    var requestLocationSetting by remember { mutableStateOf(false) }


        LocationPermissionsDialog(
            onPermissionGranted = {
                requestLocationSetting = true
            },
            onPermissionDenied = {
                requestLocationSetting = true
            },
        )


    if (requestLocationSetting) {

        LocationSettingDialog(
            onSuccess = {
                requestLocationSetting = false
                updateCurrentLocation()
            },
            onFailure = {
                requestLocationSetting = false
                updateCurrentLocation()
            },
        )
    }
}