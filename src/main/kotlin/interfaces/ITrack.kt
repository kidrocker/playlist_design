package interfaces

import models.Track

interface ITrack {
    fun addTrack(track: Track)
    fun addTracks(tracks: List<Track>)
    fun deleteTrack(track: Track)
    fun deleteTracks(tracks: List<Track>)
    fun getTotalDuration(): Long
    fun getNumberOfTracks(): Int
    fun getTrack(id:Int):Track
    fun getAllTracks():List<Track>
}