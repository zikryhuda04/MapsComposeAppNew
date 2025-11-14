package com.example.mapscomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.rememberMarkerState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // PERBAIKAN FINAL: Menggunakan koordinat yang Anda berikan.
            val universitasNegeriPadang = LatLng(-0.8972, 100.3502)

            val cameraPositionState = rememberCameraPositionState {
                // Arahkan kamera langsung ke lokasi UNP
                position = CameraPosition.fromLatLngZoom(universitasNegeriPadang, 15f) // Zoom lebih dekat (misal: 15f)
            }

            // Gunakan variabel 'universitasNegeriPadang' untuk posisi marker
            val markerState = rememberMarkerState(position = universitasNegeriPadang)

            GoogleMap(
                cameraPositionState = cameraPositionState
            ) {
                Marker(
                    state = markerState,
                    title = "Universitas Negeri Padang",
                    snippet = "Alam Takambang Jadi Guru"
                )
            }
        }
    }
}
