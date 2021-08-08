import interfaces.ITrack
import models.Track
import models.User

class Playlist(private val user: User): ITrack {

    private val mTrack = mutableSetOf<Track>()


    override fun addTrack(track: Track) {
        TODO("Not yet implemented")
    }

    override fun addTracks(tracks: List<Track>) {
        TODO("Not yet implemented")
    }

    override fun deleteTrack(track: Track) {
        TODO("Not yet implemented")
    }

    override fun deleteTracks(tracks: List<Track>) {
        TODO("Not yet implemented")
    }

    override fun getTotalDuration(): Long {
        TODO("Not yet implemented")
    }

    override fun getNumberOfTracks(): Int {
        TODO("Not yet implemented")
    }

    override fun getTrack(id:Int): Track {
        TODO("Not yet implemented")
    }

    override fun getAllTracks(): List<Track> {
        TODO("Not yet implemented")
    }
}