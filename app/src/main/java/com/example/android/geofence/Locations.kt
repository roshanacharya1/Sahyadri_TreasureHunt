package com.example.android.geofence

import android.content.Context
import com.google.android.gms.location.GeofenceStatusCodes
import com.google.android.gms.maps.model.LatLng
import java.util.concurrent.TimeUnit

fun errorMessage(context: Context, errorCode: Int): String {
    val resources = context.resources
    return when (errorCode) {
        GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE -> resources.getString(
            R.string.geofence_not_available
        )
        GeofenceStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES -> resources.getString(
            R.string.geofence_too_many_geofences
        )
        GeofenceStatusCodes.GEOFENCE_TOO_MANY_PENDING_INTENTS -> resources.getString(
            R.string.geofence_too_many_pending_intents
        )
        else -> resources.getString(R.string.unknown_geofence_error)
    }
}

data class LandmarkDataObject(val id: String, val hint: Int, val name: Int, val latLong: LatLng)

internal object GeofencingConstants {


    val GEOFENCE_EXPIRATION_IN_MILLISECONDS: Long = TimeUnit.HOURS.toMillis(1)

    val LANDMARK_DATA = arrayOf(
        LandmarkDataObject(
            "golden_gate_bridge",
            R.string.golden_gate_bridge_hint,
            R.string.golden_gate_bridge_location,
            LatLng(12.87453, 74.93932)),

        LandmarkDataObject(
            "ferry_building",
            R.string.ferry_building_hint,
            R.string.ferry_building_location,
            LatLng(12.87330, 74.93428)),

        LandmarkDataObject(
            "pier_39",
            R.string.pier_39_hint,
            R.string.pier_39_location,
            LatLng(12.87157, 74.93663)),

        LandmarkDataObject(
            "union_square",
            R.string.union_square_hint,
            R.string.union_square_location,
            LatLng(12.86684, 74.92500))
    )

    val NUM_LANDMARKS = LANDMARK_DATA.size
    const val GEOFENCE_RADIUS_IN_METERS = 100f
    const val EXTRA_GEOFENCE_INDEX = "GEOFENCE_INDEX"
}
