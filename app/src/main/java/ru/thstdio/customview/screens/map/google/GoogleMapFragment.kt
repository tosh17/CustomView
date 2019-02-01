package ru.thstdio.customview.screens.map.google

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_map_google.view.*
import ru.thstdio.customview.R
import ru.thstdio.thmaps.base.OnThMapReady
import ru.thstdio.thmaps.entity.ThPoint
import ru.thstdio.thmaps.entity.ThPointIcons
import ru.thstdio.thmaps.googlemap.ThGoogleMap

class GoogleMapFragment : Fragment(), OnThMapReady {


    private lateinit var map: ThGoogleMap

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_map_google, container, false)
        map = root.thGoogleMap
        map.onMapReady = this
        lifecycle.addObserver(map)
        root.thGoogleMap.onCreate(savedInstanceState)
        activity?.let {

        }

        return root
    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }

    override fun onMapReady() {
        map.setIcon(ThPointIcons("OrangeStar",R.drawable.ic_star_orange_24dp))
        map.setIcon(ThPointIcons("GreenSmile",R.drawable.ic_green_smile))
        val point1 = ThPoint(title = "Point#1", latitude = 34.0,longitude = 58.0)
        val point2 = ThPoint(title = "Point#2", latitude = 36.0,longitude = 62.0,icon = "GreenSmile")
        val point3 = ThPoint(title = "Point#2", latitude = 32.0,longitude = 54.0,icon = "OrangeStar")

        map.addPoint(point1)
        map.addPoint(point2)
        map.addPoint(point3)
    }
}