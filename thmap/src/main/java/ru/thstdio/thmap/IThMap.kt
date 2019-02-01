package ru.thstdio.thmap

import ru.thstdio.thmap.entity.LngLat
import ru.thstdio.thmap.entity.ThPoint

interface IThMap {
    fun zoomMinus()
    fun zoomPlus()
    fun setIcon()
    fun addPoint(point: ThPoint)
    fun addPoint(points:Collection<ThPoint>)
    fun addCircle(lat: LngLat,radius:Int)
    fun clearPoints()

}