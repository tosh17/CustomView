package ru.thstdio.thmaps.base

import ru.thstdio.thmaps.entity.LngLat
import ru.thstdio.thmaps.entity.ThPoint
import ru.thstdio.thmaps.entity.ThPointIcons

interface IThMap {
    fun zoomMinus()
    fun zoomPlus()
    fun setIcon(icon: ThPointIcons)
    fun setIcon(icons: Collection<ThPointIcons>)
    fun addPoint(point: ThPoint)
    fun addPoint(points: Collection<ThPoint>)
    fun addCircle(lat: LngLat, radius: Int)
    fun clearPoints()

}