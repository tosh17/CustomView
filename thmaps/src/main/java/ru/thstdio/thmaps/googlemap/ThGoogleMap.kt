package ru.thstdio.thmaps.googlemap

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.*
import ru.thstdio.thmaps.base.ThBaseMap
import ru.thstdio.thmaps.entity.LngLat
import ru.thstdio.thmaps.entity.ThPoint
import ru.thstdio.thmaps.entity.ThPointIcons
import ru.thstdio.thmaps.googlemap.mvp.presenter.PresenterGoogleMap
import ru.thstdio.thmaps.util.UiUtil

class ThGoogleMap : ThBaseMap {

    var presenter: PresenterGoogleMap = PresenterGoogleMap()
    val points: MutableMap<ThPoint, Marker> = HashMap()
    val pointIcons: MutableMap<String, BitmapDescriptor> = HashMap()

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    //Googlemap value
    private var mapViewDelegate: MapView? = null

    private lateinit var mGoogleMap: GoogleMap

    override fun init(context: Context) {
        mapViewDelegate = MapView(context)
        addView(mapViewDelegate)
        mapViewDelegate!!.getMapAsync { googleMap ->
            googleMap.run {
                mGoogleMap = this
                Log.d("ThMap", "MapReady")
                getUiSettings().setCompassEnabled(true)
                getUiSettings().setMapToolbarEnabled(true)
                getUiSettings().setRotateGesturesEnabled(true)
                getUiSettings().setZoomControlsEnabled(false)
            }
            onMapReady?.onMapReady()
        }
    }

    fun onCreate(savedState: Bundle?) {
        mapViewDelegate?.onCreate(savedState)
    }


    fun onStart() {
        mapViewDelegate?.onStart()
    }

    fun onStop() {
        mapViewDelegate?.onStop()
    }

    fun onResume() {
        mapViewDelegate?.onResume()
    }

    fun onPause() {
        mapViewDelegate?.onPause()
    }

    fun onDestroy() {
        mapViewDelegate?.onDestroy()
    }

    fun onLowMemory() {
        mapViewDelegate?.onLowMemory()
    }

    fun onSaveInstanceState(savedState: Bundle) {
        mapViewDelegate?.onSaveInstanceState(savedState)
    }


    override fun zoomMinus() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun zoomPlus() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setIcon(icon: ThPointIcons) {
        pointIcons[icon.iconName] = createBitmapDescriptor(icon.resId)
    }

    override fun setIcon(icons: Collection<ThPointIcons>) {
        icons.forEach { icon -> pointIcons[icon.iconName] = createBitmapDescriptor(icon.resId) }
    }

    private fun createBitmapDescriptor(res: Int): BitmapDescriptor {
        return BitmapDescriptorFactory.fromBitmap(UiUtil.drawableToBitmap(getContext(), res))
    }

    override fun addPoint(point: ThPoint) {
        createMarker(point)
    }

    override fun addPoint(points: Collection<ThPoint>) {
        points.forEach { point -> createMarker(point) }
    }

    override fun addCircle(lat: LngLat, radius: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearPoints() {
        points.forEach { (point, marker) -> marker.remove() }
        points.clear()
    }

    private fun createMarker(point: ThPoint) {
        val option = MarkerOptions()
            .position(LatLng(point.latitude, point.longitude))
            .anchor(0.5f, 1f)
        point.icon.let {
            option.icon(pointIcons[it])
        }
        val poiMarker = mGoogleMap.addMarker(option)
        poiMarker.tag = point
        points[point] = poiMarker
    }
}